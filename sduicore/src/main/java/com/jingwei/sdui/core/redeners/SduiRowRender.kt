package com.jingwei.sdui.core.redeners

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jingwei.sdui.core.attributes.toHorizontalArrangement
import com.jingwei.sdui.core.component.SduiRow
import com.jingwei.sdui.core.component.attribute.fractional
import com.jingwei.sdui.core.component.attribute.toModifier
import com.jingwei.sdui.core.component.attribute.toVerticalAlignment

@Composable
fun SduiRow.render(modifier: Modifier) {
    Row(
        horizontalArrangement = this.mainAxisAlignment.toHorizontalArrangement(),
        verticalAlignment = this.crossAxisAlignment.toVerticalAlignment(),
        modifier = modifier
    ) {
        children.forEach { node ->
            val nodeModifier = node.modifier.toModifier(this, node.modifier.fractional())
            node.render(nodeModifier)
        }
    }
}