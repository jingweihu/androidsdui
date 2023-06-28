package com.jingwei.sdui.core.component

import com.jingwei.sdui.core.attributes.SduiMainAxisAlignment
import com.jingwei.sdui.core.component.attribute.SduiCrossAxisAlignment
import com.jingwei.sdui.core.component.attribute.SduiModifier


data class SduiLazyColumn(
    override val id: Long = -1,
    override val modifier: SduiModifier? = null,
    val mainAxisAlignment: SduiMainAxisAlignment,
    val crossAxisAlignment: SduiCrossAxisAlignment,
    val children: List<SduiComponent>,
) : SduiComponent