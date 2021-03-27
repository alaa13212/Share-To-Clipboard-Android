package me.barrak.sharetoclipboard.ui.main

import me.barrak.sharetoclipboard.util.*

class MockMainViewModel : IMainViewModel {
    override val canShareClipboard: Boolean= true

    override var autoCopy: Boolean = true
    override var autoClose: Boolean = false

    override fun navigateToCopyActivity() {
        logD("navigateToCopyActivity()")
    }

    override fun shareClipboard() {
        logD("shareClipboard")
    }
}