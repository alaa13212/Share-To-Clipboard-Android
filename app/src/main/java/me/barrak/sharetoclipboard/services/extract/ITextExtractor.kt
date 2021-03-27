package me.barrak.sharetoclipboard.services.extract

interface ITextExtractor {
    fun extractElements(text: String): List<String>
}