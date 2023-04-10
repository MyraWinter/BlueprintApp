package com.myra_winter.hiltblueprint.ui.onboarding

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myra_winter.hiltblueprint.R
import com.myra_winter.hiltblueprint.data.repository.DataStoreRepository
import com.myra_winter.hiltblueprint.data.repository.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveAuthState(
                if (completed) UserState.HOME else UserState.ONBOARDING
            )
        }
    }

}

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
