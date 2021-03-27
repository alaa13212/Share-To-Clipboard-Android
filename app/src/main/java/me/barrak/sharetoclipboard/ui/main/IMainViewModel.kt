package me.barrak.sharetoclipboard.ui.main

import me.barrak.sharetoclipboard.services.prefs.*

interface IMainViewModel {
    val canShareClipboard: Boolean
    var autoCopy: Boolean
    var autoClose: Boolean
    fun navigateToCopyActivity()
    fun shareClipboard()
}