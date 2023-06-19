package com.jingwei.sdui.core.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.RowScope

enum class SduiMainAxisAlignment {
    START,
    END,
    CENTER,
    SPACE_BETWEEN,
    SPACE_AROUND,
    UNKNOWN
}


fun SduiMainAxisAlignment.toVerticalArrangement(): Arrangement.Vertical {
    return when (this) {
        SduiMainAxisAlignment.START -> Arrangement.Top
        SduiMainAxisAlignment.END -> Arrangement.Bottom
        SduiMainAxisAlignment.CENTER -> Arrangement.Center
        SduiMainAxisAlignment.SPACE_BETWEEN -> Arrangement.SpaceBetween
        SduiMainAxisAlignment.SPACE_AROUND -> Arrangement.SpaceAround
        else -> {
            throw IllegalArgumentException("illegal scope in cross axis alignment")
        }
    }
}

fun SduiMainAxisAlignment.toHorizontalArrangement(): Arrangement.Horizontal {
    return when (this) {
        SduiMainAxisAlignment.START -> Arrangement.Start
        SduiMainAxisAlignment.END -> Arrangement.End
        SduiMainAxisAlignment.CENTER -> Arrangement.Center
        SduiMainAxisAlignment.SPACE_BETWEEN -> Arrangement.SpaceBetween
        SduiMainAxisAlignment.SPACE_AROUND -> Arrangement.SpaceAround
        else -> {
            throw IllegalArgumentException("illegal scope in cross axis alignment")
        }
    }
}
