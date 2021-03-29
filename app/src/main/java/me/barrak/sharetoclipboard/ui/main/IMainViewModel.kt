package me.barrak.sharetoclipboard.ui.main

interface IMainViewModel {
    val canShareClipboard: Boolean
    var justCopy: Boolean
    var autoClose: Boolean
    var useExtractors: Boolean

    fun navigateToCopyActivity()
    fun shareClipboard()
    fun shareApp()
    fun versionClicked()
}