package com.jingwei.sdui.core.component.attribute

import androidx.compose.ui.text.style.TextAlign

enum class SduiTextAlign {
    START,
    END,
    CENTER
}

fun SduiTextAlign.toTextAlign(): TextAlign {
    return when (this) {
        SduiTextAlign.START -> TextAlign.Start
        SduiTextAlign.END -> TextAlign.End
        SduiTextAlign.CENTER -> TextAlign.Center
    }
}