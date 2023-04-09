package com.myra_winter.hiltblueprint.data.repository

import androidx.annotation.DrawableRes
import com.myra_winter.hiltblueprint.R

sealed class OnboardingData(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnboardingData(
        image = R.drawable.undraw_book_reading_re_fu2c,
        title = "Books",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Second : OnboardingData(
        image = R.drawable.undraw_love_it_cixe,
        title = "Rate",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Third : OnboardingData(
        image = R.drawable.undraw_love_it_cixe,
        title = "Start",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
