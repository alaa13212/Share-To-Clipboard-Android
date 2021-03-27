package me.barrak.sharetoclipboard.activities

import android.os.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.*
import me.barrak.sharetoclipboard.services.copy.*
import me.barrak.sharetoclipboard.services.navigation.*
import me.barrak.sharetoclipboard.services.prefs.*
import me.barrak.sharetoclipboard.services.share.*
import me.barrak.sharetoclipboard.ui.*
import me.barrak.sharetoclipboard.ui.main.*

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels {
        val preferencesService = PreferencesService(this)
        val shareService = ShareService(this)
        val copyService = CopyService(this)
        val navigationService = NavigationService(this)
        MainViewModelFactory(preferencesService, shareService, copyService, navigationService)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App {
                MainScreen(viewModel)
            }
        }
    }
}

@Preview(showBackground = true, name = "App")
@Composable
private fun DefaultPreview() = App {
    MainScreen(MockMainViewModel())
}

@Preview(showBackground = true, name = "App Dark")
@Composable
private fun DefaultPreviewDark() = DarkApp {
    MainScreen(MockMainViewModel())
}