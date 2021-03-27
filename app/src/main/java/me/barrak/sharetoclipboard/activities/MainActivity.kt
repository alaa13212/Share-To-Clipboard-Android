package me.barrak.sharetoclipboard.activities

import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.main.*

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels {
        val preferencesService = PreferencesService(applicationContext)
        val shareService = ShareService(applicationContext)
        MainViewModelFactory(preferencesService, shareService)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

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
fun DefaultPreview() = App {
    Greeting("Android")
}

@Preview(showBackground = true, name = "App Dark")
@Composable
fun DefaultPreviewDark() = DarkApp {
    Greeting("Android")
}