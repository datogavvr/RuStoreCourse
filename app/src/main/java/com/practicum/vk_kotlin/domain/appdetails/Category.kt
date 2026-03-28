package com.practicum.vk_kotlin.domain.appdetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category {
    @SerialName("Приложения")
    APP,

    @SerialName("Игры")
    GAME,

    @SerialName("Производительность")
    PRODUCTIVITY,

    @SerialName("Общение")
    SOCIAL,

    @SerialName("Образование")
    EDUCATION,

    @SerialName("Развлечения")
    ENTERTAINMENT,

    @SerialName("Музыка")
    MUSIC,

    @SerialName("Фото и видео")
    PHOTOGRAPHY,

    @SerialName("Здоровье и фитнес")
    HEALTH,

    @SerialName("Образ жизни")
    LIFESTYLE,

    @SerialName("Спорт")
    SPORTS,

    @SerialName("Новости")
    NEWS,

    @SerialName("Погода")
    WEATHER,

    @SerialName("Книги и справочники")
    BOOKS,

    @SerialName("Бизнес")
    BUSINESS,

    @SerialName("Финансы")
    FINANCE,

    @SerialName("Навигация")
    TRAVEL,

    @SerialName("Еда и напитки")
    FOOD,

    @SerialName("Шопинг")
    SHOPPING,

    @SerialName("Утилиты")
    UTILITIES
}