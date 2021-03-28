package me.barrak.sharetoclipboard.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import me.barrak.sharetoclipboard.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.prefs.*


@Composable
fun PreferenceScreen(viewModel: IMainViewModel) = Column {
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

    InfoPreferenceItem(stringResource(R.string.app_version), { }, description = "v" + BuildConfig.VERSION_NAME)
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    PreferenceScreen(MockMainViewModel())
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    PreferenceScreen(MockMainViewModel())
}