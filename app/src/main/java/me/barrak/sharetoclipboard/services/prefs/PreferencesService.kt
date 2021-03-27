package me.barrak.sharetoclipboard.services.prefs

import android.content.*
import androidx.compose.runtime.*
import java.lang.UnsupportedOperationException

class PreferencesService(context: Context) : IPreferencesService {

    internal val prefs by lazy {
        context.getSharedPreferences("me.barrak.sharetoclipboard.USER_PREFERENCES", Context.MODE_PRIVATE)
            ?: throw UnsupportedOperationException("Clipboard service not available")
    }

    override var autoCopy: Boolean by booleanPref("autoCopy")
    override var autoClose: Boolean by booleanPref("autoClose")


}