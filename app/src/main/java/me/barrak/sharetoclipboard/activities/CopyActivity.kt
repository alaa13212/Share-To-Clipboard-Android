package me.barrak.sharetoclipboard.activities

import android.content.*
import android.os.*
import android.widget.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.material.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.extract.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.copy.*
import me.barrak.sharetoclipboard.util.*

class CopyActivity : ComponentActivity() {
    val viewModel: CopyViewModel by viewModels{
        val copyService = CopyService(applicationContext)
        val extractor = CompositeTextExtractor()
        CopyViewModelFactory(copyService, extractor)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedText =  if(intent?.action == Intent.ACTION_SEND && intent.type == MimeTypeText)
            intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
        else ""

        if(sharedText.isNotBlank()) {
            viewModel.copyItem(sharedText)
            Toast.makeText(applicationContext, "Text Copied", Toast.LENGTH_SHORT).show()
        }

        setContent {
            App {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(sharedText)
                }
            }
        }
    }
}