package com.jingwei.sdui.core.redeners

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
        else -> {
            throw IllegalArgumentException("$this Component has not been supported")
        }
    }
}