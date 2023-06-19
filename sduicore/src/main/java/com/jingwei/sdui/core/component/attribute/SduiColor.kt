package com.jingwei.sdui.core.component.attribute

import androidx.compose.ui.graphics.Color

@JvmInline
value class SduiColor(val value: Long)

fun SduiColor?.toColor(): Color {
    return this?.let {
        Color(it.value)
    } ?: Color.Unspecified
}