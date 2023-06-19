package com.jingwei.sdui.core.component.attribute

import androidx.compose.ui.layout.ContentScale

enum class SduiImageFit {
    NONE,
    FILL,
}

fun SduiImageFit.toContentScale(): ContentScale {
    return when (this) {
        SduiImageFit.NONE -> ContentScale.None
        SduiImageFit.FILL -> ContentScale.Fit
        else -> throw java.lang.IllegalArgumentException("Not supported")
    }
}