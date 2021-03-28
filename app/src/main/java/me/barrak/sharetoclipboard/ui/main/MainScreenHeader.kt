package me.barrak.sharetoclipboard.ui.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.ui.*

@Composable
fun MainScreenHeader() {
    Column(Modifier.padding(16.dp)) {
        Text(stringResource(me.barrak.sharetoclipboard.R.string.app_welcome), Modifier.fillMaxWidth())
        Box(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 8.dp)
                .size(96.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = me.barrak.sharetoclipboard.R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = me.barrak.sharetoclipboard.R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
        Text(
            stringResource(me.barrak.sharetoclipboard.R.string.copy),
            Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    MainScreenHeader()
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    MainScreenHeader()
}