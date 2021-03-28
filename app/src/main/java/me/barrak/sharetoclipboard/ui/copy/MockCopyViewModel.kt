package me.barrak.sharetoclipboard.ui.copy

import me.barrak.sharetoclipboard.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.util.*
import me.barrak.sharetoclipboard.util.events.*

class MockCopyViewModel : ICopyViewModel {
    override val items: List<TextElement> = listOf(
        TextElement(R.string.type_full_text, "Text with number in it. 123456 more text here long message", listOf()),
        TextElement(R.string.type_link, "Hello Text welcome https://stackoverflow.com/questions/22770178/how-can-i-validate-a-url-in-android?dasdsa=dsadsa more text blah blah blah", listOf("https://stackoverflow.com/questions/22770178/how-can-i-validate-a-url-in-android?dasdsa=dsadsa", "https://stackoverflow.com", "stackoverflow.com")),
        TextElement(R.string.type_number, "SA94 5000 0000 0103 6972 5009", listOf("SA9450000000010369725009", "9450000000010369725009", "94", "5000", "0000", "0103", "6972", "5009")),
    )
    override val onItemCopied: Event
        get() = Event()

    override val autoCopy = false
    override val autoClose = false

    override fun copyItem(text: String) {
        logD("copyItem($text)")
    }

    override fun processText(text: String) {
        logD("processText($text)")
    }

    override fun getCopiedText(): String {
        logD("getCopiedText()")
        return ""
    }
}