package com.myra_winter.hiltblueprint.ui.splashscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myra_winter.hiltblueprint.data.repository.DataStoreRepository
import com.myra_winter.hiltblueprint.data.repository.UserState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<UserState> = mutableStateOf(UserState.UNKNOWN)
    val startDestination: State<UserState> = _startDestination

    init {
        viewModelScope.launch {
            repository.readAuthState().collect { state ->
                _startDestination.value = state
            }
            _isLoading.value = false
        }
    }
}