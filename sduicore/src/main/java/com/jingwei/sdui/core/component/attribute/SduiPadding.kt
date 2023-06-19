package com.jingwei.sdui.core.component.attribute

data class SduiPadding(
    val start: Int = 0,
    val end: Int = 0,
    val top: Int = 0,
    val bottom: Int = 0,
)

val NONE_PADDING = SduiPadding(0, 0, 0, 0)