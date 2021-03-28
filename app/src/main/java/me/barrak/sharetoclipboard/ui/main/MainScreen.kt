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
            Column(Modifier.weight(1f)) {
                Column(Modifier.padding(16.dp)) {
                    Text(stringResource(R.string.app_welcome))
                    Box(
                        Modifier
                            .padding(top = 16.dp, bottom = 8.dp)
                            .size(96.dp)
                            .align(Alignment.CenterHorizontally)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
                        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
                    }
                    Text(stringResource(R.string.copy), Modifier.align(Alignment.CenterHorizontally), fontSize = 20.sp)
                }

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