package com.jingwei.sdui.core.component.attribute

import androidx.compose.ui.layout.ContentScale

enum class SduiImageFit {
    NONE,
    FILL,
    FILL_BOUNDS,
}

fun SduiImageFit.toContentScale(): ContentScale {
    return when (this) {
        SduiImageFit.NONE -> ContentScale.None
        SduiImageFit.FILL -> ContentScale.Fit
        SduiImageFit.FILL_BOUNDS -> ContentScale.FillBounds
        else -> throw java.lang.IllegalArgumentException("Not supported")
    }
}