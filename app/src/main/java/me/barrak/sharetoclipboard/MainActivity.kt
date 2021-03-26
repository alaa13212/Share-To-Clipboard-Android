package me.barrak.sharetoclipboard

import android.content.*
import android.os.Bundle
import android.widget.*
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.barrak.sharetoclipboard.services.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.main.*
import me.barrak.sharetoclipboard.ui.theme.ShareToClipboardTheme

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels{
        val copyService = CopyService(applicationContext)
        MainViewModelFactory(copyService)
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
            ShareToClipboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(sharedText)
                }
            }
        }
    }

    companion object {
        private const val MimeTypeText = "text/plain"
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, name = "App")
@Composable
fun DefaultPreview() = App {
    Greeting("Android")
}

@Preview(showBackground = true, name = "App Dark")
@Composable
fun DefaultPreviewDark() = DarkApp {
    Greeting("Android")
}