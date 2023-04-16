package com.myra_winter.hiltblueprint.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

// Color helper: https://encycolorpedia.de/5e2028

//import android.graphics.Color as c
// Color.parseColor(myPassedColor)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
/**
 * If you want to get the size in pixels:
 * val screenDensity = configuration.densityDpi / 160f
 * and multiply with dp, for example
 * val screenHeight = configuration.screenHeightDp.toFloat() * screenDensity.
 * You might want to round to a whole number as well. since px is Int.
 */


val MainColor = Color(0xFF8080ff)
val white = Color.White
val fav1 = Color(0xFF102c54) // Perlnachtblau
val fav2 = Color(0xFF5e2129) // Weinrot
val beige = Color(0xFFfff8e5) //



val favGradientColorList = listOf(fav1, fav2)

val customVerticalGradient = Brush.verticalGradient(
    0.0f to fav1,
    0.8f to fav2,
    1.0f to white,
    startY = Float.MIN_VALUE,
    endY = Float.POSITIVE_INFINITY
)
val customVerticalGradientCut = Brush.verticalGradient(
    0.0f to fav2,
    1.5f to fav1,
    //0.7f to white,
    startY = Float.MIN_VALUE,
    endY = Float.POSITIVE_INFINITY
)