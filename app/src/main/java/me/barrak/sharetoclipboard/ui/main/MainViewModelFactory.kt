package me.barrak.sharetoclipboard.ui.main

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.navigation.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*

class MainViewModelFactory(
    private val preferencesService: IPreferencesService,
    private val shareService: IShareService,
    private val copyService: ICopyService,
    private val navigationService: INavigationService,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IPreferencesService::class.java, IShareService::class.java, ICopyService::class.java, INavigationService::class.java)
            .newInstance(preferencesService, shareService, copyService, navigationService)
    }
}