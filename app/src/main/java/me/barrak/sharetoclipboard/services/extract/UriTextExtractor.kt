package me.barrak.sharetoclipboard.services.extract

import android.net.*
import android.util.*
import me.barrak.sharetoclipboard.*


class UriTextExtractor : ITextExtractor {
    override fun extractElements(text: String): List<TextElement> {
        val extractRegex: Regex = Patterns.WEB_URL.toRegex()
        return extractRegex.findAll(text)
            .map { matchResult -> clean(matchResult.value) }
            .toList()
    }

    private fun clean(text: String): TextElement {
        val elements = mutableListOf<String>().apply {
            val uri = Uri.parse(text)
            add(text.removeSuffix("/")) // Original
            add(uri.scheme + "://" + uri.authority + uri.path) // No params
            add(uri.scheme + "://" + uri.authority) // No path
            add(uri.authority.toString()) // No protocol
        }.distinct()

        return TextElement(R.string.type_link, elements.first(), elements.drop(1))
    }
}