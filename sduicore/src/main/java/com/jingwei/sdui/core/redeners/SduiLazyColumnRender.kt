package com.jingwei.sdui.core.redeners

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jingwei.sdui.core.attributes.toVerticalArrangement
import com.jingwei.sdui.core.component.SduiLazyColumn
import com.jingwei.sdui.core.component.attribute.fractional
import com.jingwei.sdui.core.component.attribute.toHorizontalAlignment
import com.jingwei.sdui.core.component.attribute.toModifier


@Composable
fun SduiLazyColumn.render(modifier: Modifier) {
    LazyColumn(
        verticalArrangement = this.mainAxisAlignment.toVerticalArrangement(),
        horizontalAlignment = this.crossAxisAlignment.toHorizontalAlignment(),
        modifier = modifier
    ) {
        children.forEach { node ->
            val nodeModifier = node.modifier.toModifier(this, node.modifier.fractional())
            item {
                node.render(nodeModifier)
            }
        }
    }
}