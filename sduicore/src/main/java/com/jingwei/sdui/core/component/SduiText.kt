package com.jingwei.sdui.core.component

import com.jingwei.sdui.core.component.attribute.SduiColor
import com.jingwei.sdui.core.component.attribute.SduiModifier
import com.jingwei.sdui.core.component.attribute.SduiTextAlign

data class SduiText(
    override val id: Long?,
    override val modifier: SduiModifier?,
    val text: String,
    val color: SduiColor,
    val fontSize: Int,
    val textAlign: SduiTextAlign,
    val maxLine: Int?
) : SduiComponent
