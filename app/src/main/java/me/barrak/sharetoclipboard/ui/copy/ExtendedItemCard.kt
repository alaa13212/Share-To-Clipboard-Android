package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*
import java.util.*
import kotlin.math.*

import me.barrak.sharetoclipboard.R

@Composable
fun ExtendedItemCard(
    text: TextElement,
    onClick: (String) -> Unit,
    collapseCut: Int = 3,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        var expanded by rememberSaveable(text.primaryElement) { mutableStateOf(text.elements.size < collapseCut) }
        val elementsToDraw = if(expanded) text.elements.size else min(collapseCut - 1, text.elements.size)

        Column() {
            Column(Modifier.fillMaxWidth().clickable { onClick(text.primaryElement) }.padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 18.dp)) {
                Disabled(true) {
                    Text(
                        text = stringResource(text.type).toUpperCase(Locale.ROOT),
                        style = MaterialTheme.typography.body2,
                    )
                }
                Text(
                    text = text.primaryElement,
                    style = MaterialTheme.typography.body1
                )
            }
            Column(Modifier.fillMaxWidth().animateContentSize()) {
                Disabled(true) {
                    Text(
                        text = stringResource(R.string.other_formats).toUpperCase(Locale.ROOT),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.body2,
                    )
                }
                for ((index, element) in text.elements.take(elementsToDraw).withIndex()) {
                    if (index != 0)
                        Divider(Modifier.padding(horizontal = 16.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onClick(element) }
                            .padding(16.dp),
                        text = element,
                        style = MaterialTheme.typography.body1
                    )
                }
            }

            TextButton(
                onClick = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth().height(38.dp),
            ) {
                Text(
                    text = stringResource(if(expanded) R.string.less else R.string.more).toUpperCase(Locale.ROOT),
                    style = MaterialTheme.typography.body2,
                )
            }

        }
    }
}


@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    ExtendedItemCard(MockCopyViewModel().items[2], {})
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    ExtendedItemCard(MockCopyViewModel().items[2], {})
}