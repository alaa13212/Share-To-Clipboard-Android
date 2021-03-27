package me.barrak.sharetoclipboard.services.copy

interface ICopyService {
    fun copy(text: String, label: String = "Shared Text")
    fun getCopiedText(): String?
}