package com.practicum.vk_kotlin.data

import com.practicum.vk_kotlin.data.appdetails.AppDetailsDto
import com.practicum.vk_kotlin.data.home.HomeAppDetailsDto
import com.practicum.vk_kotlin.domain.appdetails.Category
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

// Представим, что этот класс ходит в сеть.
class AppApi @Inject constructor() {
    suspend fun getAppDetails(): AppDetailsDto {
        // Эмулируем загрузку с бэкенда
        delay(1.seconds)
        val app = AppDetailsDto(
            name = "Гильдия Героев: Экшен ММО РПГ",
            developer = "VK Play",
            category = Category.APP,
            ageRating = 12,
            size = 223.7,
            screenshots = listOf(
                "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
                "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            ),
            icon = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
            description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
        )
        return app
    }

    suspend fun getAppsList(): List<HomeAppDetailsDto> {
        delay(1.seconds)
        val apps = listOf(
            HomeAppDetailsDto(
                name = "Сбербанк Онлайн - с Салютом",
                category = Category.FINANCE,
                iconUrl = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
                shortDescription = "Больше чем банк",
            ),
            HomeAppDetailsDto(
                name = "Яндекс.Браузер - с Алисой",
                category = Category.UTILITIES,
                iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
                shortDescription = "Быстрый и безопасный браузер",
            ),
            HomeAppDetailsDto(
                name = "ВКонтакте",
                category = Category.SOCIAL,
                iconUrl = "https://static.rustore.ru/imgproxy/gi7isSeWaOdDyern23Uv4oSv4Lv8xRn8D-IKzQ8dEY0/preset:web_app_icon_62/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp",
                shortDescription = "Лучше вместе"
            ),
            HomeAppDetailsDto(
                name = "Авито",
                category = Category.SHOPPING,
                iconUrl = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
                shortDescription = "Здесь решают люди"
            ),
            HomeAppDetailsDto(
                name = "Яндекс Лавка",
                category = Category.FOOD,
                iconUrl = "https://static.rustore.ru/imgproxy/ypWTAv2uZ4oLEedPtkx5n6HtVS8JnlILz4PMmdfqvHo/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/12/10/8a/apk/345615295/content/ICON/47dbcfc9-c183-4dbc-9da3-f40a6a98a559.png@webp",
                shortDescription = "Хочу пиццу"
            ),
            HomeAppDetailsDto(
                name = "DDX Fitness",
                category = Category.SPORTS,
                iconUrl = "https://static.rustore.ru/imgproxy/k0V2y3HC-7hPlyPLEbfwQpkTxTBW6AyyhQ9RE_-L9eI/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/2063542256/content/ICON/61811336-a1fe-43f9-9152-a500aebb977a.png@webp",
                shortDescription = "Сила в единстве",
            )
        )
        return apps
    }
}