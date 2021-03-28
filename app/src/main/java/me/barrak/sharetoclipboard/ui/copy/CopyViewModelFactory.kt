package me.barrak.sharetoclipboard.ui.copy

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.services.prefs.*

class CopyViewModelFactory(
    private val copyService: ICopyService,
    private val textExtractor: ITextExtractor,
    private val preferencesService: IPreferencesService,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ICopyService::class.java, ITextExtractor::class.java, IPreferencesService::class.java)
            .newInstance(copyService, textExtractor, preferencesService)
    }
}

