package com.jingwei.sdui.core.redeners

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jingwei.sdui.core.attributes.toVerticalArrangement
import com.jingwei.sdui.core.component.SduiColumn
import com.jingwei.sdui.core.component.attribute.fractional
import com.jingwei.sdui.core.component.attribute.toHorizontalAlignment
import com.jingwei.sdui.core.component.attribute.toModifier

@Composable
fun SduiColumn.render(modifier: Modifier) {
    Column(
        verticalArrangement = this.mainAxisAlignment.toVerticalArrangement(),
        horizontalAlignment = this.crossAxisAlignment.toHorizontalAlignment(),
        modifier = modifier
    ) {
        children.forEach { node ->
            val nodeModifier = node.modifier.toModifier(this, node.modifier.fractional())
            node.render(nodeModifier)
        }
    }
}