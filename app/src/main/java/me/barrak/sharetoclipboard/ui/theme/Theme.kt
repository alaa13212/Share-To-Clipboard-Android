package me.barrak.sharetoclipboard.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.*

private val DarkColorPalette = darkColors(
    primary = Teal200,
    primaryVariant = Teal700,
    secondary = Purple200,
    onPrimary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Teal500,
    primaryVariant = Teal700,
    secondary = Purple200,
)

@Composable
fun ShareToClipboardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}