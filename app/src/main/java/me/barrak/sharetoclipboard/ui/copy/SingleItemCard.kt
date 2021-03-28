package me.barrak.sharetoclipboard.ui.copy

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.components.*
import java.util.*

@Composable
fun SingleItemCard(
    text: TextElement,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = { onClick(text.primaryElement) }),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 16.dp)) {
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
    }
}


@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    SingleItemCard(MockCopyViewModel().items[0]) { }
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    SingleItemCard(MockCopyViewModel().items[0]) { }
}