package me.barrak.sharetoclipboard.services.extract

import me.barrak.sharetoclipboard.*

private val extractRegex = Regex("""(\b[A-Z$]{1,3}[ \-,.]*|\b)*(\d+[ \-,.]*)+""")
private val cleanRegex = Regex("""[ \-,.]*""")
private val digitsRegex = Regex("""\d+""")
private val charactersRegex = Regex("""^[A-Z$]+""")

class NumbersTextExtractor : ITextExtractor {
    override fun extractElements(text: String): List<TextElement> {
        return extractRegex.findAll(text)
            .map { matchResult -> clean(matchResult.value) }
            .toList()
    }

    private fun clean(text: String): TextElement {
        val elements = mutableListOf<String>().apply {
            add(text.trim()) // Original
            add(text.replace(cleanRegex, "")) // Cleaned
            add(text.replace(charactersRegex, "").trim()) // Number only
            add(digitsRegex.findAll(text).joinToString("") { it.value }) // Cleaned digits only
            addAll(digitsRegex.findAll(text).map { it.value }) // Parts
        }.distinct()

        return TextElement(R.string.type_number, elements.first(), elements.drop(1))
    }
}