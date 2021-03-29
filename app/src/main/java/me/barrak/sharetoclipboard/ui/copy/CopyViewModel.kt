package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.runtime.*
import androidx.lifecycle.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.util.events.*

class CopyViewModel (
    private val copyService: ICopyService,
    private val textExtractor: ITextExtractor,
    private val preferencesService: IPreferencesService,
) : ViewModel(), ICopyViewModel {

    override var items: List<TextElement> by mutableStateOf(listOf())
        private set

    override val onItemCopied: Event = Event()

    override val justCopy get() = preferencesService.justCopy
    override val autoClose get() = preferencesService.autoClose
    override val useExtractors: Boolean get() = preferencesService.useExtractors


    override fun copyItem(text: String) {
        copyService.copy(text)
        onItemCopied()
    }

    override fun processText(text: String) {
        items = if(useExtractors) {
            val list = textExtractor.extractElements(text)
            list.take(1) + list.drop(1)
                .filterNot { it.primaryElement == list.firstOrNull()?.primaryElement && it.elements.isEmpty() }
        } else {
            listOf(TextElement(R.string.type_full_text, text, listOf()))
        }
    }

    override fun getCopiedText(): String {
        return copyService.getCopiedText() ?: ""
    }
}