package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*

@Composable
fun CopyScreen(
    viewModel: ICopyViewModel,
) {
    Scaffold(
        topBar = { AppTopBar() },
    ) {
        Column(Modifier.fillMaxHeight()) {
            LazyColumn {
                stickyHeader {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.primaryVariant,
                    ) {
                        Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                            Text(stringResource(R.string.extracted_items_list), style = MaterialTheme.typography.h6)
                            Text(stringResource(R.string.click_item_to_copy), style = MaterialTheme.typography.caption)
                        }
                    }
                }

                items(viewModel.items) { item ->
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clickable(onClick = { viewModel.copyItem(item) }),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 4.dp,
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = item,
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
            }
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