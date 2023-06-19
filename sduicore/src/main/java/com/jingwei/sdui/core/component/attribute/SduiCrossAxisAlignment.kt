package com.jingwei.sdui.core.component.attribute

import androidx.compose.ui.Alignment

enum class SduiCrossAxisAlignment {
    START,
    END,
    CENTER,
    UNKNOWN
}

fun SduiCrossAxisAlignment.toHorizontalAlignment(): Alignment.Horizontal {
    return when (this) {
        SduiCrossAxisAlignment.START -> Alignment.Start
        SduiCrossAxisAlignment.END -> Alignment.End
        SduiCrossAxisAlignment.CENTER -> Alignment.CenterHorizontally
        else -> {
            throw IllegalArgumentException("illegal scope in cross axis alignment")
        }
    }
}

fun SduiCrossAxisAlignment.toVerticalAlignment(): Alignment.Vertical {
    return when (this) {
        SduiCrossAxisAlignment.START -> Alignment.Top
        SduiCrossAxisAlignment.END -> Alignment.Bottom
        SduiCrossAxisAlignment.CENTER -> Alignment.CenterVertically
        else -> {
            throw IllegalArgumentException("illegal scope in cross axis alignment")
        }
    }
}