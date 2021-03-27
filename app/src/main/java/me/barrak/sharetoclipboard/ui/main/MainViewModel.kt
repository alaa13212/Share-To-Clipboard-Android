package me.barrak.sharetoclipboard.ui.main

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*

class MainViewModel(
    private val preferencesService: IPreferencesService,
    val shareService: IShareService
) : ViewModel() {

}