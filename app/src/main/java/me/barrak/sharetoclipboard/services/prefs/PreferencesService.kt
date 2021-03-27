package me.barrak.sharetoclipboard.services.prefs

import android.content.*
import java.lang.UnsupportedOperationException

class PreferencesService(context: Context) : IPreferencesService {

    internal val prefs by lazy {
        context.getSharedPreferences("me.barrak.sharetoclipboard.USER_PREFERENCES", Context.MODE_PRIVATE)
            ?: throw UnsupportedOperationException("Clipboard service not available")
    }

    var autoClose: Boolean by booleanPref("autoClose")




}