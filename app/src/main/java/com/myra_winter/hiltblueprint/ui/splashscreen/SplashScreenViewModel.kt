package com.myra_winter.hiltblueprint.ui.splashscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myra_winter.hiltblueprint.data.repository.DataStoreRepository
import com.myra_winter.hiltblueprint.data.repository.UserAuthState
import com.myra_winter.hiltblueprint.ui.navigation.NavigationItem
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> =
        mutableStateOf(NavigationItem.Onboarding.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readAuthState().collect { state ->
                when (state) {
                    // TODO implement authenticated and unauthenticated

                    UserAuthState.AUTHENTICATED -> _startDestination.value =
                        NavigationItem.Home.route
                    UserAuthState.ONBOARDING -> _startDestination.value =
                        NavigationItem.Onboarding.route
                    UserAuthState.UNAUTHENTICATED -> TODO()
                    UserAuthState.UNKNOWN -> _startDestination.value =
                        NavigationItem.Onboarding.route
                }
            }
            _isLoading.value = false
        }
    }
}