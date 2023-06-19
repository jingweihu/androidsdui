package com.jingwei.sdui.core.component

import com.jingwei.sdui.core.component.attribute.SduiImageFit
import com.jingwei.sdui.core.component.attribute.SduiModifier

data class SduiImage(
    override val id: Long? = -1,
    override val modifier: SduiModifier? = null,
    val url: String,
    val fit: SduiImageFit
) : SduiComponent