package me.barrak.sharetoclipboard.ui.copy

interface ICopyViewModel {
    val items: List<String>
    fun copyItem(text: String)
    fun processText(text: String)
    fun getCopiedText(): String
}
