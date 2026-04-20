package com.practicum.vk_kotlin.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vk_kotlin.domain.home.GetHomeAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeAppsUseCase: GetHomeAppsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<HomeEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getApps()
    }

    fun showOnLogoClickMessage() {
        viewModelScope.launch {
            _events.send(HomeEvent.OnLogoClick)
        }
    }

    fun getApps() {
        viewModelScope.launch {
            _state.value = HomeState.Loading

            runCatching {
                val apps = getHomeAppsUseCase()

                _state.value = HomeState.Content(apps = apps)
            }.onFailure { error ->
                android.util.Log.e("HomeViewModel", "Ошибка загрузки списка приложений", error)
                _state.value = HomeState.Error
            }
        }
    }
}