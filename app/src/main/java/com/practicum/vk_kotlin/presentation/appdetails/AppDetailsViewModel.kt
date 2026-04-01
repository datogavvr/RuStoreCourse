package com.practicum.vk_kotlin.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vk_kotlin.domain.CoroutineDispatchers
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository,
    savedStateHandle: SavedStateHandle,
    private val dispatchers: CoroutineDispatchers
) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    private val id = savedStateHandle.get<String>("id") ?: ""

    init {
        observeAppDetails()
        getAppDetails()
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = true)
            } else {
                currentState
            }
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch(dispatchers.io()) {
            appDetailsRepository.toggleFavorite(id)
        }
    }

    fun getAppDetails() {
        viewModelScope.launch(dispatchers.io()) {
            _state.value = AppDetailsState.Loading
            runCatching {
                appDetailsRepository.get(id)
            }.onFailure { error ->
                Log.e("AppDetailsViewModel", "Ошибка загрузки данных о приложении", error)
                _state.value = AppDetailsState.Error
            }
        }
    }

    fun observeAppDetails() {
        viewModelScope.launch(dispatchers.io()) {
            appDetailsRepository.observeAppDetails(id)
                .catch { _state.value = AppDetailsState.Error }
                .collect { appDetails ->
                    _state.update { currentState ->
                        AppDetailsState.Content(
                            appDetails = appDetails,
                            descriptionCollapsed = (currentState as? AppDetailsState.Content)?.descriptionCollapsed
                                ?: false
                        )
                    }
                }
        }
    }
}