package me.barrak.sharetoclipboard.ui.main

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*

class MainViewModelFactory(
    private val preferencesService: IPreferencesService,
    val shareService: IShareService
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IPreferencesService::class.java, IShareService::class.java)
            .newInstance(preferencesService, shareService)
    }
}