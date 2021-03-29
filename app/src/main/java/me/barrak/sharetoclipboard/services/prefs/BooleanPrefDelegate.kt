package me.barrak.sharetoclipboard.services.prefs

import androidx.core.content.*

internal fun booleanPref(key: String, defaultValue: Boolean = false) = BooleanPrefDelegate(key, defaultValue)

internal class BooleanPrefDelegate(key: String, defaultValue: Boolean = false) : AbstractPrefDelegate<Boolean>(key, defaultValue,
    { pref -> pref.getBoolean(key, defaultValue) },
    { pref, value -> pref.edit { putBoolean(key, value)} }
)