package me.barrak.sharetoclipboard.services.share

import android.content.*
import androidx.core.app.*
import me.barrak.sharetoclipboard.*
import me.barrak.sharetoclipboard.util.*

class ShareService(private val context: Context)  : IShareService {
    override fun share(text: String) {
        val intent = ShareCompat.IntentBuilder(context)
            .setChooserTitle(context.getString(R.string.share_copied_text))
            .setText(text)
            .setType(MimeTypeText)
            .createChooserIntent()

        context.startActivity(intent)
    }
}