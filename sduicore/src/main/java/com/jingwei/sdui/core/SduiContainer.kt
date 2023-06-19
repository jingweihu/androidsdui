package com.jingwei.sdui.core

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.jingwei.sdui.core.component.SduiComponent
import com.jingwei.sdui.core.component.attribute.fractional
import com.jingwei.sdui.core.component.attribute.toModifier
import com.jingwei.sdui.core.redeners.render

@Composable
fun SduiContainer(sduiComponent: SduiComponent) {
    Surface {
        sduiComponent.render(sduiComponent.modifier.toModifier(null, sduiComponent.modifier.fractional()))
    }
}