package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.runtime.*
import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*

class CopyViewModel (
    private val copyService: ICopyService,
    private val textExtractor: ITextExtractor,
) : ViewModel(), ICopyViewModel {

    override var items: List<String> by mutableStateOf(listOf())
        private set

    override fun copyItem(text: String) {
        copyService.copy(text)
    }

    override fun processText(text: String) {
        items = textExtractor.extractElements(text)
    }

    override fun getCopiedText(): String {
        return copyService.getCopiedText() ?: ""
    }
}