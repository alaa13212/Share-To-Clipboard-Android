package me.barrak.sharetoclipboard.services.extract

import android.util.*
import me.barrak.sharetoclipboard.*

private val extractRegex: Regex = Patterns.EMAIL_ADDRESS.toRegex()

class EmailTextExtractor : ITextExtractor {
    override fun extractElements(text: String): List<TextElement> {
        return extractRegex.findAll(text)
            .map { matchResult -> clean(matchResult.value) }
            .toList()
    }

    private fun clean(text: String): TextElement {
        val elements = mutableListOf<String>().apply {
            add(text) // Original
            add("mailto:$text") // No params
        }.distinct()

        return TextElement(R.string.type_email, elements.first(), elements.drop(1))
    }
}