package me.barrak.sharetoclipboard.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*
import me.barrak.sharetoclipboard.ui.components.prefs.*
import java.util.*


@Composable
fun MainScreen(
    viewModel: IMainViewModel,
) {
    Scaffold(
        topBar = { AppTopBar(
            onShareClick = if(viewModel.canShareClipboard) viewModel::shareClipboard else null
        ) },
    ) {
        Column(Modifier.fillMaxHeight()) {
            Spacer(modifier = Modifier.height(16.dp))
            Column(Modifier.weight(1f)) {
                PreferenceDivider(false)
                PreferenceTitle("Settings")

                CheckboxPreferenceItem(
                    text = "Auto copy",
                    checked = viewModel.autoCopy,
                    onCheckedChange = { viewModel.autoCopy = it },
                    description = "Will auto copy full text if nothing was found to extract",
                    uncheckedDescription = "Will not auto copy full text if nothing was found to extract"
                )

                CheckboxPreferenceItem(
                    text = "Auto close when copied",
                    checked = viewModel.autoClose,
                    onCheckedChange = { viewModel.autoClose = it },
                    description = "App will close after copy",
                    uncheckedDescription = "App will not close after copy",
                    enabled = viewModel.autoCopy
                )
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