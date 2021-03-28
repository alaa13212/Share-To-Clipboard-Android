package me.barrak.sharetoclipboard.services.extract

import android.net.*
import android.util.*


class UriTextExtractor : ITextExtractor {
    override fun extractElements(text: String): List<String> {
        val extractRegex: Regex = Patterns.WEB_URL.toRegex()
        return extractRegex.findAll(text)
            .map { matchResult -> matchResult.value }
            .flatMap { clean(it).distinct() }
            .toList()
    }

    private fun clean(text: String): List<String> {
        return mutableListOf<String>().apply {
            val uri = Uri.parse(text)
            add(text) // Original
            add(uri.scheme + "://" + uri.authority + uri.path) // No params
            add(uri.scheme + "://" + uri.authority) // No path
            add(uri.authority.toString()) // No protocol
        }
    }
}