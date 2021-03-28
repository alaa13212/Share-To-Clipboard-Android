package me.barrak.sharetoclipboard.services.extract

import me.barrak.sharetoclipboard.*

class IdentityTextExtractor: ITextExtractor {
    override fun extractElements(text: String)
        = listOf(TextElement(R.string.type_full_text, text, listOf()))
}