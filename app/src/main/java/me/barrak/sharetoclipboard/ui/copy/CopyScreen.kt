package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*

@Composable
fun CopyScreen(
    viewModel: ICopyViewModel,
) {
    Scaffold(
        topBar = { AppTopBar() },
    ) {
        Column {

        }
    }
}


@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    CopyScreen(MockCopyViewModel())
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    CopyScreen(MockCopyViewModel())
}