package me.barrak.sharetoclipboard.ui.main

import androidx.lifecycle.*
import me.barrak.sharetoclipboard.services.*

class MainViewModelFactory(private val copyService: ICopyService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ICopyService::class.java)
            .newInstance(copyService)
    }
}