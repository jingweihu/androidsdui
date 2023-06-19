package com.jingwei.sdui.core.component

import com.jingwei.sdui.core.component.attribute.SduiModifier

sealed interface SduiComponent {
    val id: Long?
    val modifier: SduiModifier?
}