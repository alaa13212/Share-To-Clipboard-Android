package me.barrak.sharetoclipboard.services

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

    override fun extractElements(text: String): List<String> {
        return listOf(text)
    }
}