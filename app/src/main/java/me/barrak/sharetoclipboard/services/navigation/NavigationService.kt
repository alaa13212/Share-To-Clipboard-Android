package me.barrak.sharetoclipboard.services.navigation

import android.content.*
import me.barrak.sharetoclipboard.activities.*

class NavigationService(private val context: Context) : INavigationService {
    override fun navigateToCopyActivity() {
        start<CopyActivity>()
    }

    private inline fun <reified T> start() {
        val intent = Intent(context, T::class.java)
        context.startActivity(intent)
    }
}