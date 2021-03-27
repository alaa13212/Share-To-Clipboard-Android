package me.barrak.sharetoclipboard.ui.components.prefs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.ui.*
import java.util.*


@Composable
fun PreferenceTitle(title: String = "Settings") {
    Text(
        text = title.toUpperCase(Locale.ROOT),
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.subtitle2,
        modifier = Modifier.padding(start = 72.dp)
    )
}


@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    PreferenceTitle()
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    PreferenceTitle()
}