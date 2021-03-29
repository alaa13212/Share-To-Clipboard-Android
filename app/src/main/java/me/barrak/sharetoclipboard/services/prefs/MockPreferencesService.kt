package me.barrak.sharetoclipboard.services.prefs

class MockPreferencesService : IPreferencesService {
    override var justCopy: Boolean = false
    override var autoClose: Boolean = true
    override var useExtractors: Boolean = true
}