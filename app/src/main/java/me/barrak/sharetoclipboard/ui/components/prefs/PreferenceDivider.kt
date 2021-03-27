package me.barrak.sharetoclipboard.ui.components.prefs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

@Composable
fun PreferenceDivider(
    indent: Boolean = true
) {
    Divider(Modifier.padding(
        start = if (indent) 72.dp else 16.dp,
        top = 16.dp,
        bottom = 16.dp,
        end = 16.dp
    ))
}