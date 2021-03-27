package me.barrak.sharetoclipboard.ui.components.prefs

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*

@Composable
fun CheckboxPreferenceItem(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    uncheckedDescription: String? = description,
    enabled: Boolean = true,
) {
    Disabled(!enabled) {

        val newModifier = if (enabled)
            modifier.clickable(onClick = { onCheckedChange(!checked) })
        else
            modifier

        ListItem(
            modifier = newModifier,
            icon = { Spacer(Modifier) },
            text = { Disabled(!enabled) { Text(text) } },
            secondaryText = if (description != null) {
                { Disabled(!enabled) { Text(text = if (checked) description else uncheckedDescription!!) } }
            } else null,
            trailing = {
                Switch(
                    checked = checked,
                    onCheckedChange = onCheckedChange,
                    enabled = enabled
                )
            },
        )
    }
}

@Preview(showBackground = true, name = "Unchecked")
@Composable
private fun UncheckedPreview() = App {
    CheckboxPreferenceItem("Test Preference", false, {})
}

@Preview(showBackground = true, name = "Unchecked Dark")
@Composable
private fun UncheckedPreviewDark() = DarkApp {
    CheckboxPreferenceItem("Test Preference", false, {})
}

@Preview(showBackground = true, name = "Checked")
@Composable
private fun CheckedPreview() = App {
    CheckboxPreferenceItem("Test Preference", true, {})
}

@Preview(showBackground = true, name = "Checked Dark")
@Composable
private fun CheckedPreviewDark() = DarkApp {
    CheckboxPreferenceItem("Test Preference", true, {})
}