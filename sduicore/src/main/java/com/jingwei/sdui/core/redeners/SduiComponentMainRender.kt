package com.jingwei.sdui.core.redeners

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jingwei.sdui.core.component.*


@Composable
fun SduiComponent.render(modifier: Modifier) {
    when (this) {
        is SduiColumn -> this.render(modifier)
        is SduiRow -> this.render(modifier)
        is SduiBox -> this.render(modifier)
        is SduiImage -> this.render(modifier)
        is SduiText -> this.render(modifier)
        is SduiSpacer -> this.render(modifier)
        is SduiLazyRow -> this.render(modifier)
        is SduiLazyColumn -> this.render(modifier)
        else -> {
            Log.e("Sdui", "${this.javaClass} Component has not been supported")
        }
    }
}