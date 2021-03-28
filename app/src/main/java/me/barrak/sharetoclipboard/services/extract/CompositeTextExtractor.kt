package me.barrak.sharetoclipboard.services.extract

class CompositeTextExtractor(
    private var extractors: List<ITextExtractor> = listOf(IdentityTextExtractor())
) : ITextExtractor {

    override fun extractElements(text: String): List<TextElement> {
         return extractors.flatMap { it.extractElements(text) }
    }

    fun addExtractor(extractor: ITextExtractor) {
        extractors = extractors + listOf(extractor)
    }
}