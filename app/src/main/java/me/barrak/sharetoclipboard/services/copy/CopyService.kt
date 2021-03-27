package me.barrak.sharetoclipboard.services.copy

import android.content.*

import androidx.core.content.*
import java.lang.UnsupportedOperationException


class CopyService(private val context: Context) : ICopyService {

    private val clipboard by lazy {
        context.getSystemService<ClipboardManager>()
            ?: throw UnsupportedOperationException("Clipboard service not available")
    }

    override fun copy(text: String, label: String) {
        val clip = ClipData.newPlainText("Shared text", text)
        clipboard.setPrimaryClip(clip)
    }

    override fun getCopiedText(): String? {
        val clipData = clipboard.primaryClip ?: return null
        if(!clipData.description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) return null

        for (index in 0 until clipData.itemCount) {
            val item = clipData.getItemAt(index)
            if(item.text != null)
                return item.coerceToText(context).toString()
        }

        return null
    }
}