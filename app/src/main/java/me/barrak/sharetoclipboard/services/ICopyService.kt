package me.barrak.sharetoclipboard.services

interface ICopyService {
    fun copy(text: String, label: String = "Shared Text")
    fun extractElements(text: String): List<String>
}