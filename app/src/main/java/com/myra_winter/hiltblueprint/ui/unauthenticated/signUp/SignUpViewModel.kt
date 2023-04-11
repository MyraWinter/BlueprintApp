package com.myra_winter.hiltblueprint.ui.unauthenticated.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myra_winter.hiltblueprint.data.repository.DataStoreRepository
import com.myra_winter.hiltblueprint.data.repository.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    fun saveOnBoardingState(userState: UserState) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUserState(userState)
        }
    }

}

