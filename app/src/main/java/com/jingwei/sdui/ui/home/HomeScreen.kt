package com.jingwei.sdui.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jingwei.sdui.core.SduiContainer

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val uiState by homeViewModel.uiState.collectAsState()
    uiState.content?.let {
        SduiContainer(sduiComponent = it)
    }
}