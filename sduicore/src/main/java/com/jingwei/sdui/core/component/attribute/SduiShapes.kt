package com.jingwei.sdui.core.component.attribute

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

enum class ShapeType {
    ROUNDED_CORNER,
    CIRCLE,
}

sealed class SduiShape {
    data class RoundedCornerShape(
        val topStart: Int = 0,
        val topEnd: Int = 0,
        val bottomStart: Int = 0,
        val bottomEnd: Int = 0,
    ) : SduiShape()

    object CircleShape : SduiShape()
}

fun SduiShape?.toShape(): Shape {
    return if (this == null) {
        RectangleShape
    } else {
        when (this) {
            is SduiShape.RoundedCornerShape -> RoundedCornerShape(
                topStart = this.topStart.dp, topEnd = this.topEnd.dp,
                bottomStart = this.bottomStart.dp, bottomEnd = this.bottomEnd.dp
            )
            is SduiShape.CircleShape -> CircleShape
        }
    }
}
