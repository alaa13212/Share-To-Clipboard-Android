package me.barrak.sharetoclipboard.services.prefs

import android.content.*
import kotlin.reflect.*

open class AbstractPrefDelegate<T>(
    protected val key: String,
    protected val defaultValue: T,
    private val getter: (SharedPreferences) -> T,
    private val setter: (SharedPreferences, T) -> Unit
) {

    operator fun getValue(preferencesService: PreferencesService, property: KProperty<*>): T {
        return getter(preferencesService.prefs)
    }

    operator fun setValue(preferencesService: PreferencesService, property: KProperty<*>, value: T) {
        setter(preferencesService.prefs, value)
    }
}