package me.barrak.sharetoclipboard.services.navigation

interface INavigationService {
    fun navigateToCopyActivity(message: String? = null)
}