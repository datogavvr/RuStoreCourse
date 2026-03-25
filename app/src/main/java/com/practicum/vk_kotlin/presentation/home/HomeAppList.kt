package com.practicum.vk_kotlin.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practicum.vk_kotlin.domain.appdetails.Category
import com.practicum.vk_kotlin.domain.home.HomeAppDetails
import com.practicum.vk_kotlin.presentation.theme.VkKotlinTheme


@Composable
internal fun HomeAppList(
    apps: List<HomeAppDetails>,
    modifier: Modifier = Modifier,
    onAppClick: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(
                topStart = 28.dp,
                topEnd = 28.dp,
                )
            )
            .background(MaterialTheme.colorScheme.surface),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(apps) { app ->
                HomeAppCard(
                    icon = app.iconUrl,
                    title = app.name,
                    description = app.shortDescription,
                    category = app.category,
                    onClick = { onAppClick(app.id) }
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun LightPreview() {
    VkKotlinTheme {
        val apps = listOf(
            HomeAppDetails(
                id = "1",
                name = "Сбербанк Онлайн - с Салютом",
                category = Category.FINANCE,
                iconUrl = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
                shortDescription = "Больше чем банк",
            ),
            HomeAppDetails(
                id = "2",
                name = "Яндекс.Браузер - с Алисой",
                category = Category.UTILITIES,
                iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
                shortDescription = "Быстрый и безопасный браузер",
            ),
            HomeAppDetails(
                id = "3",
                name = "ВКонтакте",
                category = Category.SOCIAL,
                iconUrl = "https://static.rustore.ru/imgproxy/gi7isSeWaOdDyern23Uv4oSv4Lv8xRn8D-IKzQ8dEY0/preset:web_app_icon_62/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp",
                shortDescription = "Лучше вместе"
            ),
            HomeAppDetails(
                id = "4",
                name = "Авито",
                category = Category.SHOPPING,
                iconUrl = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
                shortDescription = "Здесь решают люди"
            ),
            HomeAppDetails(
                id = "5",
                name = "Яндекс Лавка",
                category = Category.FOOD,
                iconUrl = "https://static.rustore.ru/imgproxy/ypWTAv2uZ4oLEedPtkx5n6HtVS8JnlILz4PMmdfqvHo/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/12/10/8a/apk/345615295/content/ICON/47dbcfc9-c183-4dbc-9da3-f40a6a98a559.png@webp",
                shortDescription = "Хочу пиццу"
            ),
            HomeAppDetails(
                id = "6",
                name = "DDX Fitness",
                category = Category.SPORTS,
                iconUrl = "https://static.rustore.ru/imgproxy/k0V2y3HC-7hPlyPLEbfwQpkTxTBW6AyyhQ9RE_-L9eI/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/2063542256/content/ICON/61811336-a1fe-43f9-9152-a500aebb977a.png@webp",
                shortDescription = "Сила в единстве",
            )
        )
        HomeAppList(apps = apps) {}
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkPreview() {
    VkKotlinTheme {
        val apps = listOf(
            HomeAppDetails(
                id = "1",
                name = "Сбербанк Онлайн - с Салютом",
                category = Category.FINANCE,
                iconUrl = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
                shortDescription = "Больше чем банк",
            ),
            HomeAppDetails(
                id = "2",
                name = "Яндекс.Браузер - с Алисой",
                category = Category.UTILITIES,
                iconUrl = "https://static.rustore.ru/imgproxy/rGr87NnjSOsiX-imht9uyNnHK-YDQJNvIlY2rIb4gsA/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
                shortDescription = "Быстрый и безопасный браузер",
            ),
            HomeAppDetails(
                id = "3",
                name = "ВКонтакте",
                category = Category.SOCIAL,
                iconUrl = "https://static.rustore.ru/imgproxy/gi7isSeWaOdDyern23Uv4oSv4Lv8xRn8D-IKzQ8dEY0/preset:web_app_icon_62/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp",
                shortDescription = "Лучше вместе"
            ),
            HomeAppDetails(
                id = "4",
                name = "Авито",
                category = Category.SHOPPING,
                iconUrl = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
                shortDescription = "Здесь решают люди"
            ),
            HomeAppDetails(
                id = "5",
                name = "Яндекс Лавка",
                category = Category.FOOD,
                iconUrl = "https://static.rustore.ru/imgproxy/ypWTAv2uZ4oLEedPtkx5n6HtVS8JnlILz4PMmdfqvHo/preset:web_app_icon_62/plain/https://static.rustore.ru/2025/12/10/8a/apk/345615295/content/ICON/47dbcfc9-c183-4dbc-9da3-f40a6a98a559.png@webp",
                shortDescription = "Хочу пиццу"
            ),
            HomeAppDetails(
                id = "6",
                name = "DDX Fitness",
                category = Category.SPORTS,
                iconUrl = "https://static.rustore.ru/imgproxy/k0V2y3HC-7hPlyPLEbfwQpkTxTBW6AyyhQ9RE_-L9eI/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/2063542256/content/ICON/61811336-a1fe-43f9-9152-a500aebb977a.png@webp",
                shortDescription = "Сила в единстве",
            )
        )
        HomeAppList(apps = apps) {}
    }
}