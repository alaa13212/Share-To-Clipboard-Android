package me.barrak.sharetoclipboard.services.navigation

import android.content.*
import me.barrak.sharetoclipboard.activities.*
import me.barrak.sharetoclipboard.util.*

class NavigationService(private val context: Context) : INavigationService {
    override fun navigateToCopyActivity(message: String?) {
        start<CopyActivity>(message)
    }

    private inline fun <reified T> start(message: String?) {
        val intent = Intent(context, T::class.java)
        if(message != null) with(intent) {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = MimeTypeText
        }
        context.startActivity(intent)
    }
}