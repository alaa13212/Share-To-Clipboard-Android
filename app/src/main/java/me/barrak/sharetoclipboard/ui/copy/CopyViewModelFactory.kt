package me.barrak.sharetoclipboard.ui.copy

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*

class CopyViewModelFactory(
    private val copyService: ICopyService,
    private val textExtractor: ITextExtractor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ICopyService::class.java, ITextExtractor::class.java)
            .newInstance(copyService, textExtractor)
    }
}

