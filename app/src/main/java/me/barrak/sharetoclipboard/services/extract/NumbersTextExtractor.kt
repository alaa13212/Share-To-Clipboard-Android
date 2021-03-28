package me.barrak.sharetoclipboard.services.extract

private val extractRegex = Regex("""(\b[A-Z]{1,3}[ \-,.]*|\b)*(\d+[ \-,.]*)+""")
private val cleanRegex = Regex("""[ \-,.]*""")
private val digitsRegex = Regex("""\d+""")

class NumbersTextExtractor : ITextExtractor {
    override fun extractElements(text: String): List<String> {
        return extractRegex.findAll(text)
            .map { matchResult -> matchResult.value }
            .flatMap { clean(it).distinct() }
            .toList()
    }

    private fun clean(text: String): List<String> {
        return mutableListOf<String>().apply {
            add(text.trim()) // Original
            add(text.replace(cleanRegex, "")) // Cleaned
            add(digitsRegex.findAll(text).joinToString("") { it.value }) // Cleaned digits only
            addAll(digitsRegex.findAll(text).map { it.value }) // Parts
        }
    }
}