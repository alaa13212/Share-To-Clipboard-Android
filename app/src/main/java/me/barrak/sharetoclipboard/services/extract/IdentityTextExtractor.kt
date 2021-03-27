package me.barrak.sharetoclipboard.services.extract

class IdentityTextExtractor: ITextExtractor {
    override fun extractElements(text: String) = listOf(text)
}