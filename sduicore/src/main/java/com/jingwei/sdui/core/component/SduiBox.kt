package com.jingwei.sdui.core.component

import com.jingwei.sdui.core.component.attribute.SduiModifier

data class SduiBox(
    override val id: Long = -1,
    override val modifier: SduiModifier? = null,
    val children: List<SduiComponent>,
): SduiComponent