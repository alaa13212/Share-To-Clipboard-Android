package me.barrak.sharetoclipboard.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.ui.*

@Composable
fun AppTopBar(
    title: String = stringResource(R.string.app_name),
    onShareClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = title, maxLines = 2)
        },
        navigationIcon = {
            Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "App  Icon", )
        },
        actions = {
            if(onShareClick != null) {
                IconButton(onClick = onShareClick) {
                    Icon(Icons.Filled.Share, contentDescription = null)
                }
            }
        }
    )
}


@Preview
@Composable
fun AppTopBarPreview() = App {
    AppTopBar(onShareClick = {})
}

@Preview
@Composable
fun DarkAppTopBarPreview() = DarkApp {
    AppTopBar(onShareClick = {})
}