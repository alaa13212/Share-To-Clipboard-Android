package me.barrak.sharetoclipboard.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.*

@Composable
fun Disabled(disabled: Boolean, content: @Composable () -> Unit) {
    if(disabled) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            content()
        }
    } else {
        content()
    }
}