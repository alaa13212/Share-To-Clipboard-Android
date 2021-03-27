package me.barrak.sharetoclipboard.activities

import android.content.*
import android.os.*
import android.widget.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.*
import androidx.lifecycle.*
import kotlinx.coroutines.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.copy.*
import me.barrak.sharetoclipboard.ui.main.*
import me.barrak.sharetoclipboard.util.*

class CopyActivity : ComponentActivity() {
    private val viewModel: CopyViewModel by viewModels{
        val copyService = CopyService(this)
        val extractor = CompositeTextExtractor()
        CopyViewModelFactory(copyService, extractor)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Starting with Android 10 Application cannot read clipboard unless they are fully in foreground
        // Waiting for Activity to fully initialize
        lifecycle.coroutineScope.launch {
            delay(100)
            val sharedText = if(intent?.action == Intent.ACTION_SEND && intent.type == MimeTypeText)
                intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
            else viewModel.getCopiedText()

            if(sharedText.isNotBlank()) {
                viewModel.copyItem(sharedText)
                Toast.makeText(this@CopyActivity, "Text Copied", Toast.LENGTH_SHORT).show()
            }
        }

        setContent {
            App {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

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