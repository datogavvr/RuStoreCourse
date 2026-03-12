package com.practicum.vk_kotlin.ui.home

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
import com.practicum.vk_kotlin.ui.appdetails.getCategoryText
import com.practicum.vk_kotlin.ui.theme.VkKotlinTheme


@Composable
internal fun HomeAppList(
    onAppClick: () -> Unit,
) {
    val apps = listOf(
        hashMapOf(
            "icon" to "https://avatars.mds.yandex.net/get-altay/16386092/2a00000199e726cff865ff105f148cff8220/XXL_height",
            "title" to "Сбербанк Онлайн - с Салютом",
            "description" to "Больше чем банк",
            "category" to getCategoryText(Category.FINANCE)
        ),
        hashMapOf(
            "icon" to "https://www.computerra.ru/wp-content/uploads/2020/09/orig.png",
            "title" to "Яндекс.Браузер - с Алисой",
            "description" to "Быстрый и безопасный браузер",
            "category" to getCategoryText(Category.UTILITIES)
        ),
        hashMapOf(
            "icon" to "https://free-png.ru/wp-content/uploads/2022/02/free-png.ru-307.png",
            "title" to "ВКонтакте",
            "description" to "Лучше вместе",
            "category" to getCategoryText(Category.SOCIAL)
        ),
        hashMapOf(
            "icon" to "https://lens.usercontent.google.com/image?vsrid=CImOmcnrjZi0qgEQAhgBIiQ3YjFiMDMwYi1lNDljLTQ0MDMtOTM5Mi1lOGI1NTg4YjM3MzYyBiICbHUoGTjIsbKxgJiTAw&gsessionid=PeKEzKWGA0uyaaMa0TfriZ315RLfN_OOu19-iZJ2-2pk4az7EoeNlg",
            "title" to "Авито",
            "description" to "Здесь решают люди",
            "category" to getCategoryText(Category.SHOPPING)
        ),
        hashMapOf(
            "icon" to "https://yt3.googleusercontent.com/R5CLUWrDTmVrkfHgweK2RySZ8rWp3RkB8Q1otqWASpNsfsMSFjOr04q2ZxNV1nejOLSyNyTN=s900-c-k-c0x00ffffff-no-rj",
            "title" to "Яндекс Лавка",
            "description" to "Хочу пиццу",
            "category" to getCategoryText(Category.FOOD)
        ),
        hashMapOf(
            "icon" to "https://yt3.googleusercontent.com/Vmsm75pnyB0WFh2FUKit4hpXq9ixjYXUXtqzSjsc7JedL7yYb8uSFH4d0NXyzV2hzdODEYnKROA=s900-c-k-c0x00ffffff-no-rj",
            "title" to "DDX Fitness",
            "description" to "Сила в единстве",
            "category" to getCategoryText(Category.SPORTS)
        ),
    )
    Box(
        modifier = Modifier
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
                    icon = app["icon"] as String,
                    title = app["title"] as String,
                    description = app["description"] as String,
                    category = app["category"] as String,
                    onClick = onAppClick
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeAppListPreview() {
    VkKotlinTheme {
        HomeAppList {}
    }
}