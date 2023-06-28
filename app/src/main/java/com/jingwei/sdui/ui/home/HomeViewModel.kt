package com.jingwei.sdui.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jingwei.sdui.core.component.SduiComponent
import com.jingwei.sdui.repository.SduiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: SduiRepository): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(null))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun fetchHomeFeed() {
        viewModelScope.launch {
            try {
                val sduiResult = repository.getHomeFeed()
                _uiState.value = _uiState.value.copy(content = sduiResult)
            } catch (e: Exception) {
                Log.e("Error", e.stackTraceToString())
            }
        }
    }
}

data class HomeUiState(
    val content: SduiComponent?
)