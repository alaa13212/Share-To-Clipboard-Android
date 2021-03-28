package me.barrak.sharetoclipboard.ui.components.prefs

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.ui.*

@Composable
fun InfoPreferenceItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    icon: @Composable () -> Unit = { Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.padding(8.dp)) },
) {
    ListItem(
        modifier = modifier.clickable(onClick = onClick),
        icon = icon,
        text = { Text(text) },
        secondaryText = if (description != null) { { Text(text = description) } } else null,
    )
}


@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    InfoPreferenceItem("App version", {},description =  "v1.0.0")
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    InfoPreferenceItem("App version", {},description =  "v1.0.0")
}
