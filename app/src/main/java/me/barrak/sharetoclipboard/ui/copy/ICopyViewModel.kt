package me.barrak.sharetoclipboard.ui.copy

import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.util.events.*

interface ICopyViewModel {
    val items: List<TextElement>
    val onItemCopied: Event

    val autoCopy: Boolean
    val autoClose: Boolean

    fun copyItem(text: String)
    fun processText(text: String)
    fun getCopiedText(): String
}
