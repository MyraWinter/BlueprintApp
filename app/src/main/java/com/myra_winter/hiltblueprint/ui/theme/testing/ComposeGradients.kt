package com.myra_winter.hiltblueprint.ui.theme.testing

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.myra_winter.hiltblueprint.ui.theme.fav1
import com.myra_winter.hiltblueprint.ui.theme.fav2
import kotlin.math.ceil

// using Result? instead of try catch?

val mod: Modifier = Modifier.defaultMinSize(150.dp, 150.dp)


class WavyShape(
    private val period: Dp,
    private val amplitude: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ) = Outline.Generic(Path().apply {
        val wavyPath = Path().apply {
            val halfPeriod = with(density) { period.toPx() } / 2
            val amplitude = with(density) { amplitude.toPx() }
            moveTo(x = -halfPeriod / 2, y = amplitude)
            repeat(ceil(size.width / halfPeriod + 1).toInt()) { i ->
                relativeQuadraticBezierTo(
                    dx1 = halfPeriod / 2,
                    dy1 = 2 * amplitude * (if (i % 2 == 0) 1 else -1),
                    dx2 = halfPeriod,
                    dy2 = 0f,
                )
            }
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
        }
        val boundsPath = Path().apply {
            addRect(Rect(offset = Offset.Zero, size = size))
        }
        op(wavyPath, boundsPath, PathOperation.Intersect)
    })
}

@Composable
fun LinearGradient() {
    val gradient = Brush.linearGradient(
        0.0f to fav1,
        500.0f to fav2,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = mod.background(gradient))
}

@Composable
fun HorizontalGradient() {
    val gradient = Brush.horizontalGradient(
        0.0f to fav1,
        1.0f to fav2,
        startX = 0.0f,
        endX = 150.0f
    )
    Box(modifier = mod.background(gradient))
}

@Composable
fun VerticalGradient() {
    val gradient = Brush.verticalGradient(
        0.0f to fav1,
        0.7f to fav2,
        1.0f to Color.White,
        startY = 0.0f,
        endY = 400.0f
    )
    Box(modifier = mod.background(gradient))
}

@Composable
fun RadialGradient() {
    val gradient = Brush.radialGradient(
        0.0f to fav1,
        1.0f to fav2,
        radius = 150.0f,
        tileMode = TileMode.Repeated
    )
    Box(modifier = mod.background(gradient))
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextGradient() {
    Text(
        fontSize = 15.sp,
        text = ("Get started with Android (Kotlin, Jet Compose) & IOS (Swift UI), " +
                "MVVM clean architecture, and Beautiful UI UX design patterns."),
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(Color.Magenta, Color.Cyan)
            )
        )
    )
}


@Composable
fun WaveGraphic() {
    Canvas(modifier = Modifier
        .width(370.dp)
        .height(150.dp),
        onDraw = {
            val path = Path()
            val waveLength = size.width
            val waveHeight = size.height
            path.moveTo(-300f, size.height / 8)
            for (i in 0..4) {
                path.quadraticBezierTo(
                    i * waveLength + waveLength / 2, size.height / 2 - waveHeight,
                    (i + 1) * waveLength, size.height / 2
                )
                path.quadraticBezierTo(
                    (i + 1) * waveLength + waveLength / 2, size.height / 2 + waveHeight,
                    (i + 2) * waveLength, size.height / 2
                )
            }
            drawPath(
                path, color = Color(0, 117, 131), style = Stroke(width = 200f)
            )
        }
    )
}


@Composable
fun WaveGraphic2() {
    //https://medium.com/falabellatechnology/jetpack-compose-canvas-8aee73eab393
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(width.times(.0f), height.times(.0f))
            cubicTo(
                width,
                height.times(.72f),
                width,
                height.times(.41f),
                width,
                height.times(.40f)
            )
//            cubicTo(
//                width.times(.75f),
//                height.times(.21f),
//                width.times(.35f),
//                height.times(.21f),
//                width.times(.38f),
//                height.times(.50f)
//            )
//            cubicTo(
//                width.times(.25f),
//                height.times(.50f),
//                width.times(.20f),
//                height.times(.69f),
//                width.times(.41f),
//                height.times(.72f)
//            )
            close()
        }
        drawRect(
            brush =  Brush.verticalGradient(
                0.0f to Color.Magenta,
                1.0f to Color.Cyan,
                startY = 0.0f,
                endY = 150.0f
            ))
        drawPath(path = path, color = Color.White.copy(alpha = .90f))
    }
}

@Composable
fun BoxWithCircle() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
    ) {
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(Color(0, 117, 131), Color(0, 260, 131))
            ),
            size = size
        )

        drawCircle(
            color = Color.White,
            center = Offset(x = size.width / 1.7f, y = -26f),
            radius = 260f
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun WavyShapePreview() {
//    MaterialTheme {
//        Image(
//            painter = painterResource(R.drawable.tree_img),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .defaultMinSize(150.dp, 150.dp)
//                .clip(WavyShape(period = 100.dp, amplitude = 50.dp))
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun WaveGraphic2Preview() {
    MaterialTheme {
        WaveGraphic2()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        TextGradient()
    }
}

@Composable
@Preview
fun LinearGradientPreview() {
    MaterialTheme {
        LinearGradient()
    }
}

@Composable
@Preview
fun HorizontalGradientPreview() {
    MaterialTheme {
        HorizontalGradient()
    }
}

@Composable
@Preview
fun VerticalGradientPreview() {
    MaterialTheme {
        VerticalGradient()
    }
}

@Composable
@Preview
fun RadialGradientPreview() {
    MaterialTheme {
        RadialGradient()
    }
}







