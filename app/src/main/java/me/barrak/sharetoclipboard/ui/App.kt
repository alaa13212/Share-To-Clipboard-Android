package me.barrak.sharetoclipboard.ui

import androidx.compose.material.*
import androidx.compose.runtime.*
import me.barrak.sharetoclipboard.ui.theme.*


@Composable
fun App(content: @Composable () -> Unit) {
    ShareToClipboardTheme {
        Surface(content = content)
    }
}

@Composable
fun DarkApp(content: @Composable () -> Unit) {
    ShareToClipboardTheme(darkTheme = true) {
        Surface(content = content)
    }
}