package me.barrak.sharetoclipboard.ui.main

import androidx.compose.runtime.*
import androidx.lifecycle.*
import kotlinx.coroutines.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.navigation.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*
import me.barrak.sharetoclipboard.util.events.*

class MainViewModel(
    private val preferencesService: IPreferencesService,
    private val shareService: IShareService,
    private val copyService: ICopyService,
    private val navigationService: INavigationService,
) : ViewModel(), IMainViewModel {

    private var versionCounter = 7
    val showVersionToast = Event()

    override var canShareClipboard by mutableStateOf(copyService.getCopiedText() != null)

    private var _justCopy by mutableStateOf(preferencesService.justCopy)
    override var justCopy
        get() = _justCopy
        set(value) {
            preferencesService.justCopy = value
            _justCopy = value
        }

    private var _autoClose by mutableStateOf(preferencesService.autoClose)
    override var autoClose
        get() = _autoClose
        set(value) {
            preferencesService.autoClose = value
            _autoClose = value
        }

    private var _useExtractors by mutableStateOf(preferencesService.useExtractors)
    override var useExtractors
        get() = _useExtractors
        set(value) {
            preferencesService.useExtractors = value
            _useExtractors = value
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
        navigationService.navigateToCopyActivity(copyService.getCopiedText())
    }

    override fun shareClipboard() {
        val text = copyService.getCopiedText() ?: return
        shareService.share(text)
    }

    override fun shareApp() {
        shareService.share("Check out this utility https://play.google.com/store/apps/details?id=me.barrak.sharetoclipboard")
    }

    override fun versionClicked() {
        versionCounter--
        if(versionCounter < 1)
            showVersionToast()
    }

}