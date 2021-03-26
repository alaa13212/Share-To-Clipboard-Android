package me.barrak.sharetoclipboard.ui.main

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.*

class MainViewModel(private val copyService: ICopyService) : ViewModel() {
    fun copyItem(text: String) {
        copyService.copy(text)
    }

}