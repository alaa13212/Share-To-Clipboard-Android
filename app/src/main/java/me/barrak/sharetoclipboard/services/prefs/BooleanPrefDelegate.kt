package me.barrak.sharetoclipboard.services.prefs

import androidx.core.content.*

internal fun booleanPref(key: String) = BooleanPrefDelegate(key)

internal class BooleanPrefDelegate(key: String, defaultValue: Boolean = false) : AbstractPrefDelegate<Boolean>(key, defaultValue,
    { pref -> pref.getBoolean(key, defaultValue) },
    { pref, value -> pref.edit { putBoolean(key, value)} }
)