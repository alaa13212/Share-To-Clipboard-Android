package me.barrak.sharetoclipboard.services.prefs

class MockPreferencesService : IPreferencesService {
    override var autoCopy: Boolean = false
    override var autoClose: Boolean = true
}