package com.myra_winter.hiltblueprint.ui.splashscreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myra_winter.hiltblueprint.data.repository.DataStoreRepository
import com.myra_winter.hiltblueprint.data.repository.UserState
import com.myra_winter.hiltblueprint.ui.navigation.NavigationItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class HiltBlueprintViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(NavigationItem.Onboarding.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.getUserState().collect { state ->
                Log.d("APP VIEWMODEL", state.name)
                when(state) {
                    // startDestination can only be Login, Home or Onboarding
                    UserState.HOME -> _startDestination.value = NavigationItem.Home.route
                    UserState.LOGIN -> _startDestination.value = NavigationItem.Login.route
                    UserState.SIGN_UP -> _startDestination.value = NavigationItem.SignUp.route
                    UserState.ONBOARDING -> _startDestination.value = NavigationItem.Onboarding.route
                    else -> _startDestination.value = NavigationItem.Onboarding.route
                }
            }
            _isLoading.value = false
        }
    }
}