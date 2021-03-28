package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.ui.*


@Composable
fun CopyScreenHeader() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primaryVariant,
    ) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(stringResource(me.barrak.sharetoclipboard.R.string.extracted_items_list), style = MaterialTheme.typography.h6)
            Text(
                stringResource(me.barrak.sharetoclipboard.R.string.click_item_to_copy),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    CopyScreenHeader()
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    CopyScreenHeader()
}