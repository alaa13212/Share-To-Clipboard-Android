package me.barrak.sharetoclipboard.ui.copy

import me.barrak.sharetoclipboard.util.*
import me.barrak.sharetoclipboard.util.events.*

class MockCopyViewModel : ICopyViewModel {
    override val items: List<String> = listOf(
        "Text with number in it. 123456 more text here long message",
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