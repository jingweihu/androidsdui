package com.jingwei.sdui.core.redeners

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jingwei.sdui.core.component.SduiBox
import com.jingwei.sdui.core.component.attribute.fractional
import com.jingwei.sdui.core.component.attribute.toModifier

@Composable
fun SduiBox.render(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {

        children.forEach { node ->
            val nodeModifier = node.modifier.toModifier(this, node.modifier.fractional())
            node.render(nodeModifier)
        }
    }
}