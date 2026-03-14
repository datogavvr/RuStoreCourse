package com.practicum.vk_kotlin.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.vk_kotlin.domain.appdetails.Category
import com.practicum.vk_kotlin.domain.home.ShortAppDetails
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<HomeEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getShortAppDetails()
    }

    fun showOnLogoClickMessage() {
        viewModelScope.launch {
            _events.send(HomeEvent.OnLogoClick)
        }
    }

    fun getShortAppDetails() {
        viewModelScope.launch {
            _state.value = HomeState.Loading

            runCatching {
                // Эмулируем загрузку с бэкенда
                delay(1.seconds)

                // В будущем заменим этот метод на вызов API.
                val appDetails = listOf(
                    ShortAppDetails(
                        name = "Сбербанк Онлайн - с Салютом",
                        category = Category.FINANCE,
                        iconUrl = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
                        shortDescription = "Больше чем банк",
                    ),
                    ShortAppDetails(
                        name = "Яндекс.Браузер - с Алисой",
                        category = Category.UTILITIES,
                        iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
                        shortDescription = "Быстрый и безопасный браузер",
                    ),
                    ShortAppDetails(
                        name = "ВКонтакте",
                        category = Category.SOCIAL,
                        iconUrl = "https://static.rustore.ru/imgproxy/gi7isSeWaOdDyern23Uv4oSv4Lv8xRn8D-IKzQ8dEY0/preset:web_app_icon_62/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp",
                        shortDescription = "Лучше вместе"
                    ),
                    ShortAppDetails(
                        name = "Авито",
                        category = Category.SHOPPING,
                        iconUrl = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
                        shortDescription = "Здесь решают люди"
                    ),
                    ShortAppDetails(
                        name = "Яндекс Лавка",
                        category = Category.FOOD,
                        iconUrl = "https://static.rustore.ru/imgproxy/ypWTAv2uZ4oLEedPtkx5n6HtVS8JnlILz4PMmdfqvHo/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/12/10/8a/apk/345615295/content/ICON/47dbcfc9-c183-4dbc-9da3-f40a6a98a559.png@webp",
                        shortDescription = "Хочу пиццу"
                    ),
                    ShortAppDetails(
                        name = "DDX Fitness",
                        category = Category.SPORTS,
                        iconUrl = "https://static.rustore.ru/imgproxy/k0V2y3HC-7hPlyPLEbfwQpkTxTBW6AyyhQ9RE_-L9eI/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/2063542256/content/ICON/61811336-a1fe-43f9-9152-a500aebb977a.png@webp",
                        shortDescription = "Сила в единстве",
                    )
                )

                _state.value = HomeState.Content(appDetails = appDetails)
            }.onFailure {
                _state.value = HomeState.Error
            }
        }
    }
}