package me.barrak.sharetoclipboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.barrak.sharetoclipboard.ui.theme.ShareToClipboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareToClipboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, name = "App")
@Composable
fun DefaultPreview() {
    ShareToClipboardTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, name = "App Dark")
@Composable
fun DefaultPreviewDark() {
    ShareToClipboardTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }
}