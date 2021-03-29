package me.barrak.sharetoclipboard.ui.main

import android.content.res.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.tooling.preview.*
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
            val orientation = LocalConfiguration.current.orientation
            val canProcessText = viewModel.canShareClipboard && !viewModel.justCopy
            LazyColumn(Modifier.weight(1f)) {
                item{
                    MainScreenHeader()
                }

                item {
                    PreferenceDivider(false)
                    PreferenceScreen(viewModel)
                }

                if(canProcessText && orientation != Configuration.ORIENTATION_PORTRAIT)
                    item { PrimaryButton(onClick = viewModel::navigateToCopyActivity) }
            }
            if(canProcessText && orientation == Configuration.ORIENTATION_PORTRAIT)
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