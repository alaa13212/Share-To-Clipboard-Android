package me.barrak.sharetoclipboard.ui.main

import me.barrak.sharetoclipboard.util.*

class MockMainViewModel : IMainViewModel {
    override val canShareClipboard: Boolean= true

    override var justCopy: Boolean = false
    override var autoClose: Boolean = false
    override var useExtractors: Boolean = true

    override fun navigateToCopyActivity() {
        logD("navigateToCopyActivity()")
    }

    override fun shareClipboard() {
        logD("shareClipboard")
    }

    override fun shareApp() {
        logD("shareApp")
    }

    override fun versionClicked() {
        logD("versionClicked")
    }
}