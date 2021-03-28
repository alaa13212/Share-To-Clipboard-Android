package me.barrak.sharetoclipboard.ui.copy

import androidx.annotation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.ui.*
import java.util.*

@Composable
fun ListGroupTitle(@StringRes type: Int) {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.primary.copy(alpha = 0.1f))
                .padding(horizontal = 16.dp, vertical = 2.dp)
        ) {
            Text(
                stringResource(type).toUpperCase(Locale.ROOT),
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    ListGroupTitle(R.string.type_email)
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    ListGroupTitle(R.string.type_email)
}