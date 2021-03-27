package me.barrak.sharetoclipboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.ui.*


@Composable
fun PrimaryButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        onClick = onClick
    ) {
        Text(stringResource(me.barrak.sharetoclipboard.R.string.procces_clipboard_content))
    }
}


@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    PrimaryButton(onClick = {})
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    PrimaryButton(onClick = {})
}