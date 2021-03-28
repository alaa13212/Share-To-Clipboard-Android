package me.barrak.sharetoclipboard.ui.main

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*
import me.barrak.sharetoclipboard.ui.components.prefs.*


@Composable
fun MainScreen(
    viewModel: IMainViewModel,
) {
    Scaffold(
        topBar = { AppTopBar(
            onShareClick = if(viewModel.canShareClipboard) viewModel::shareClipboard else null
        ) },
    ) {

        Column {

            LazyColumn(Modifier.weight(1f)) {
                item{
                    MainScreenHeader()
                }

                item {
                    PreferenceDivider(false)
                    PreferenceScreen(viewModel)
                }

            }

            PrimaryButton(onClick = viewModel::navigateToCopyActivity)
        }
    }
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    MainScreen(MockMainViewModel())
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    MainScreen(MockMainViewModel())
}