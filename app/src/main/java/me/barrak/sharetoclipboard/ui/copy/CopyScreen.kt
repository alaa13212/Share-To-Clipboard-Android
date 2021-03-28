package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
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
            CopyScreenHeader()

            val grouped = viewModel.items.groupBy { it.type }
            LazyColumn {
                grouped.forEach { (type, items) ->
                    if(type != R.string.type_full_text) {
                        stickyHeader {
                            ListGroupTitle(type)
                        }
                    }

                    items(items) { item ->
                        when(item.elements.size){
                            0 -> SingleItemCard(text = item, onClick = viewModel::copyItem)
                            1, 2, 3 ->  ExtendedItemCard(text = item, onClick = viewModel::copyItem, collapseCut = 4)
                            else -> ExtendedItemCard(text = item, onClick = viewModel::copyItem, collapseCut = 3)
                        }
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