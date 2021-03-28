package me.barrak.sharetoclipboard.services.extract

import androidx.annotation.*

data class TextElement(
    @StringRes val type: Int,
    val primaryElement: String,
    val elements: List<String>
)