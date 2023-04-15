package com.myra_winter.hiltblueprint.ui.unauthenticated.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.myra_winter.hiltblueprint.R
import com.myra_winter.hiltblueprint.ui.theme.customComponents.CustomGradientButton
import com.myra_winter.hiltblueprint.ui.theme.customVerticalGradient
import com.myra_winter.hiltblueprint.ui.theme.white

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    onClick: () -> Unit,
) {
    val pages = listOf(
        OnboardingData.First,
        OnboardingData.Second,
        OnboardingData.Third
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(customVerticalGradient)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            OnboardingPagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,
            activeColor = white
        )

        Row(
            modifier = Modifier
                .weight(1.8f)
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = pagerState.currentPage == 2
            ) {
                CustomGradientButton(nameButton = "Sign up", onClick = { onClick() })
            }
        }
    }
}


@Composable
fun OnboardingPagerScreen(onBoardingPage: OnboardingData) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )
        Text(
            color = white,
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive
        )
        Text(
            color = white,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = onBoardingPage.description,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        OnboardingScreen {}
    }
}

sealed class OnboardingData(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
) {
    object First : OnboardingData(
        image = R.drawable.undraw_book_reading_re_fu2c,
        title = "Save your Books",
        description = "Save what you have already read. You can also create an Overview of what you want to read next."
    )

    object Second : OnboardingData(
        image = R.drawable.undraw_love_it_cixe,
        title = "Rate it",
        description = "Rate the Books you read and save your annotations. Maybe you want to read it again?"
    )

    object Third : OnboardingData(
        image = R.drawable.undraw_sign_up,
        title = "Start",
        description = "Sign up to start ^^"
    )
}