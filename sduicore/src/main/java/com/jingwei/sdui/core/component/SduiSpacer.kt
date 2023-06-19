package com.jingwei.sdui.core.component

import com.jingwei.sdui.core.component.attribute.SduiModifier

data class SduiSpacer(
    override val id: Long? = -1,
    override val modifier: SduiModifier? = null
) : SduiComponent