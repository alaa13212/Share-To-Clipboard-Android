package me.barrak.sharetoclipboard.services.extract

import android.net.*
import android.util.*
import me.barrak.sharetoclipboard.*

private val extractRegex: Regex = Patterns.WEB_URL.toRegex()
private val hasScheme: Regex = "^(http|https|rtsp)://".toRegex()

class UriTextExtractor : ITextExtractor {
    override fun extractElements(text: String): List<TextElement> {
        return extractRegex.findAll(text)
            .map { matchResult -> clean(matchResult.value) }
            .toList()
    }

    private fun clean(text: String): TextElement {
        val elements = mutableListOf<String>().apply {
            val uriText = if(hasScheme.containsMatchIn(text)) text else "https://$text"
            val uri = Uri.parse(uriText)
            add(text.removeSuffix("/")) // Original
            add(uri.scheme + "://" + uri.authority + uri.path) // No params
            add(uri.scheme + "://" + uri.authority) // No path
            add(uri.authority.toString()) // No protocol
        }.distinct()

        return TextElement(R.string.type_link, elements.first(), elements.drop(1))
    }
}