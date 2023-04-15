package com.myra_winter.hiltblueprint.ui.authenticated.api

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myra_winter.hiltblueprint.data.model.ElixirModel
import com.myra_winter.hiltblueprint.data.repository.wizardingRepo.ElixirsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


data class ElexirState(
    val data:List<ElixirModel> = emptyList(),
    val error:String = "",
    val isLoading:Boolean = false
)

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val repository: ElixirsRepository
) : ViewModel() {

    private val _responseEvent = mutableStateOf(ElexirState())
    var noteResponseEvent: State<ElexirState> = _responseEvent
        private set



    fun getElexirsFromApi() {
        viewModelScope.launch {
            repository.getElixirs()
                .onStart {
                    _responseEvent.value = ElexirState(
                        isLoading = true
                    )
                }.catch {
                    _responseEvent.value = ElexirState(
                        error = it.message ?: "Something went wrong"
                    )
                }.collect {
                    Log.d("DATA?", it.first().name ?: "null")
                    _responseEvent.value = ElexirState(
                        data = it
                    )
                }
        }
    }
}