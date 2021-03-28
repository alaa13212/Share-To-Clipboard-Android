package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.runtime.*
import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.util.events.*

class CopyViewModel (
    private val copyService: ICopyService,
    private val textExtractor: ITextExtractor,
    private val preferencesService: IPreferencesService,
) : ViewModel(), ICopyViewModel {

    override var items: List<String> by mutableStateOf(listOf())
        private set

    override val onItemCopied: Event = Event()

    override val autoCopy get() = preferencesService.autoCopy
    override val autoClose get() = preferencesService.autoClose


    override fun copyItem(text: String) {
        copyService.copy(text)
        onItemCopied()
    }

    override fun processText(text: String) {
        items = textExtractor.extractElements(text)
    }

    override fun getCopiedText(): String {
        return copyService.getCopiedText() ?: ""
    }
}