package me.barrak.sharetoclipboard.services.prefs

import android.content.*

class PreferencesService(context: Context) : IPreferencesService {

    internal val prefs by lazy {
        context.getSharedPreferences("me.barrak.sharetoclipboard.USER_PREFERENCES", Context.MODE_PRIVATE)
            ?: throw UnsupportedOperationException("Clipboard service not available")
    }
    override var justCopy: Boolean by booleanPref("justCopy")
    override var autoClose: Boolean by booleanPref("autoClose")
    override var useExtractors: Boolean by booleanPref("useExtractors", true)
}