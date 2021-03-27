package me.barrak.sharetoclipboard.ui.copy

import me.barrak.sharetoclipboard.util.*

class MockCopyViewModel : ICopyViewModel {
    override val items: List<String> = listOf()

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