package com.jingwei.sdui.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.jingwei.sdui.core.SduiContainer


@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val uiState by homeViewModel.uiState.collectAsState()
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { homeViewModel.fetchHomeFeed() }, modifier = Modifier.align(Alignment.End)) {
            Text(
                text = "Refresh",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Divider()
        uiState.content?.let {
            SduiContainer(sduiComponent = it)
        }

    }


}