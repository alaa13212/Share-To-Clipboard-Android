package me.barrak.sharetoclipboard.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
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
        Column(Modifier.fillMaxHeight()) {
            Spacer(modifier = Modifier.height(16.dp))
            Column(Modifier.weight(1f)) {
                PreferenceDivider(false)
                PreferenceTitle(stringResource(R.string.settings))

                CheckboxPreferenceItem(
                    text = stringResource(R.string.setting_auto_copy),
                    checked = viewModel.autoCopy,
                    onCheckedChange = { viewModel.autoCopy = it },
                    description = stringResource(R.string.setting_auto_copy_description),
                    uncheckedDescription = stringResource(R.string.setting_auto_copy_description2)
                )

                CheckboxPreferenceItem(
                    text = stringResource(R.string.setting_auto_close),
                    checked = viewModel.autoClose,
                    onCheckedChange = { viewModel.autoClose = it },
                    description = stringResource(R.string.setting_auto_close_description),
                    uncheckedDescription = stringResource(R.string.setting_auto_close_description2),
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