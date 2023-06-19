package com.jingwei.sdui.core.component.attribute

import androidx.compose.ui.Alignment

enum class SduiAbsoluteAlignment {
    TOP_START,
    TOP_CENTER,
    TOP_END,
    CENTER_START,
    CENTER,
    CENTER_END,
    BOTTOM_START,
    BOTTOM_CENTER,
    BOTTOM_END,
    UNKNOWN
}

fun SduiAbsoluteAlignment.toAlignment(): Alignment {
    return when(this) {
        SduiAbsoluteAlignment.TOP_START -> Alignment.TopStart
        SduiAbsoluteAlignment.TOP_CENTER -> Alignment.TopCenter
        SduiAbsoluteAlignment.TOP_END -> Alignment.TopEnd
        SduiAbsoluteAlignment.CENTER_START -> Alignment.CenterStart
        SduiAbsoluteAlignment.CENTER -> Alignment.Center
        SduiAbsoluteAlignment.CENTER_END -> Alignment.CenterEnd
        SduiAbsoluteAlignment.BOTTOM_START -> Alignment.BottomStart
        SduiAbsoluteAlignment.BOTTOM_CENTER -> Alignment.BottomCenter
        SduiAbsoluteAlignment.BOTTOM_END -> Alignment.BottomEnd
        else -> {
            throw java.lang.IllegalArgumentException()
        }
    }
}