package me.barrak.sharetoclipboard.ui.main

import androidx.compose.runtime.*
import androidx.lifecycle.*
import kotlinx.coroutines.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.navigation.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*

class MainViewModel(
    private val preferencesService: IPreferencesService,
    private val shareService: IShareService,
    private val copyService: ICopyService,
    private val navigationService: INavigationService,
) : ViewModel(), IMainViewModel {

    override var canShareClipboard by mutableStateOf(copyService.getCopiedText() != null)

    private var _autoCopy by mutableStateOf(preferencesService.autoCopy)
    override var autoCopy
        get() = _autoCopy
        set(value) {
            preferencesService.autoCopy = value
            _autoCopy = value
        }

    private var _autoClose by mutableStateOf(preferencesService.autoClose)
    override var autoClose
        get() = _autoClose
        set(value) {
            preferencesService.autoClose = value
            _autoClose = value
        }
    init {
        // TODO this is hacky, switch to events when possible. Or use different architecture
        viewModelScope.launch {
            while (coroutineContext.isActive) {
                delay(2000)
                canShareClipboard = copyService.getCopiedText() != null
            }
        }
    }


    override fun navigateToCopyActivity() {
        navigationService.navigateToCopyActivity()
    }

    override fun shareClipboard() {
        val text = copyService.getCopiedText() ?: return
        shareService.share(text)
    }

}