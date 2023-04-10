package com.myra_winter.hiltblueprint.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                if (completed) UserState.AUTHENTICATED else UserState.ONBOARDING
            )
        }
    }

}
