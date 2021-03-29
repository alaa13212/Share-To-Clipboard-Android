package me.barrak.sharetoclipboard.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.prefs.*


@Composable
fun PreferenceScreen(viewModel: IMainViewModel) {
    PreferenceTitle(stringResource(R.string.settings))

    CheckboxPreferenceItem(
        text = stringResource(R.string.setting_just_copy),
        checked = viewModel.justCopy,
        onCheckedChange = { viewModel.justCopy = it },
        description = stringResource(R.string.setting_just_copy_description),
        uncheckedDescription = stringResource(R.string.setting_just_copy_description2)
    )

    CheckboxPreferenceItem(
        text = stringResource(R.string.setting_auto_close),
        checked = viewModel.autoClose,
        onCheckedChange = { viewModel.autoClose = it },
        description = stringResource(R.string.setting_auto_close_description),
        uncheckedDescription = stringResource(R.string.setting_auto_close_description2),
        enabled = !viewModel.justCopy
    )

    CheckboxPreferenceItem(
        text = stringResource(R.string.setting_use_extractors),
        checked = viewModel.useExtractors,
        onCheckedChange = { viewModel.useExtractors = it },
        description = stringResource(R.string.setting_use_extractors_description),
        enabled = !viewModel.justCopy
    )

    InfoPreferenceItem(stringResource(R.string.app_version), viewModel::versionClicked, description = "v" + BuildConfig.VERSION_NAME)

    InfoPreferenceItem(
        text = stringResource(R.string.share_app),
        onClick = viewModel::shareApp,
        description = stringResource(R.string.share_app_description),
        icon = { Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.padding(8.dp)) }
    )
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App { Column {
    PreferenceScreen(MockMainViewModel())
}}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp { Column {
    PreferenceScreen(MockMainViewModel())
}}