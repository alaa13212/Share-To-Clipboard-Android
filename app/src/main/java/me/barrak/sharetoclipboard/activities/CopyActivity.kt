package me.barrak.sharetoclipboard.activities

import android.content.*
import android.os.*
import android.widget.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.*
import androidx.lifecycle.*
import kotlinx.coroutines.*
import me.barrak.sharetoclipboard.R
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.copy.*
import me.barrak.sharetoclipboard.util.*

class CopyActivity : ComponentActivity() {
    private val viewModel: CopyViewModel by viewModels{
        val copyService = CopyService(this)
        val extractor = CompositeTextExtractor(listOf(IdentityTextExtractor(), EmailTextExtractor(), UriTextExtractor(), NumbersTextExtractor()))
        val preferencesService = PreferencesService(this)
        CopyViewModelFactory(copyService, extractor, preferencesService)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onItemCopied += ::notifyUser

        // Starting with Android 10 Application cannot read clipboard unless they are fully in foreground
        // Waiting for Activity to fully initialize
        lifecycle.coroutineScope.launch {
            delay(100)
            val sharedText = if(intent?.action == Intent.ACTION_SEND && intent.type == MimeTypeText)
                intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
            else viewModel.getCopiedText()

            if(sharedText.isNotBlank()) {
                viewModel.processText(sharedText)
                if(viewModel.items.size == 1 && viewModel.autoCopy)
                    viewModel.copyItem(viewModel.items.first().primaryElement)
            }
        }

        setContent {
            setContent {
                App {
                    CopyScreen(viewModel)
                }
            }
        }
    }

    private fun notifyUser() {
        Toast.makeText(applicationContext, getString(R.string.copied_text), Toast.LENGTH_SHORT).show()

        if(viewModel.autoClose)
            finish()
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