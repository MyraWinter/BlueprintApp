package com.myra_winter.hiltblueprint.ui.theme.customComponents

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myra_winter.hiltblueprint.ui.theme.*
import com.myra_winter.hiltblueprint.util.bounceClick

@OptIn(ExperimentalTextApi::class)
@Composable
fun CustomBeigeButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp),
    color: ButtonColors?,
    nameButton: String = "Placeholder",
    cornerShape: Shape = customCutCornerShape,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.bounceClick(),
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        colors = color ?: ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = cornerShape
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(cornerShape)
                .padding(
                    horizontal = 16.dp, // 16 to prevent Text from being cut off
                    vertical = 8.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton, fontSize = 20.sp,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = favGradientColorList
                    )
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    MaterialTheme {
        CustomBeigeButton(
            onClick = {},
            color = ButtonDefaults.buttonColors(backgroundColor = beige)
        )
    }
}

@Composable
fun CustomGradientButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp),
    gradientColors: List<Color>,
    nameButton: String = "Placeholder",
    cornerShape: Shape = customCutCornerShape,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.bounceClick(),
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = cornerShape
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(colors = gradientColors),
                    shape = cornerShape
                )
                .clip(cornerShape)
                .padding(
                    horizontal = 16.dp, // 16 to prevent Text from being cut off
                    vertical = 8.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton, fontSize = 20.sp, color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomGradientButtonPreview() {
    MaterialTheme {
        CustomGradientButton(
            onClick = {},
            cornerShape = customCutCornerShape,
            gradientColors = favGradientColorList
        )
    }
}
@Composable
fun CustomOutlinedButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp),
    nameButton: String = "Placeholder",
    cornerShape: Shape = customCutCornerShape,
    onClick: () -> Unit,
) {
    OutlinedButton(
        border= BorderStroke(1.dp, beige),

        modifier = modifier.bounceClick(),
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = cornerShape
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(cornerShape)
                .padding(
                    horizontal = 16.dp, // 16 to prevent Text from being cut off
                    vertical = 8.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton, fontSize = 20.sp, color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, name = "Outlined Button",     backgroundColor = 0x000000)
@Composable
fun CustomOutlinedButtonPreview() {
    MaterialTheme {
        CustomOutlinedButton(
            onClick = {},
            cornerShape = customCutCornerShape,
        )
    }
}
