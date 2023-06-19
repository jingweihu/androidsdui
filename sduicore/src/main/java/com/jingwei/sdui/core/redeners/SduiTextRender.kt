package com.jingwei.sdui.core.redeners

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.jingwei.sdui.core.component.SduiText
import com.jingwei.sdui.core.component.attribute.toColor
import com.jingwei.sdui.core.component.attribute.toTextAlign

@Composable
fun SduiText.render(modifier: Modifier) {
    Text (
        text = this.text,
        modifier = modifier,
        color = this.color.toColor(),
        fontSize = this.fontSize.sp,
        textAlign = this.textAlign.toTextAlign(),
        maxLines = this.maxLine ?: Int.MAX_VALUE,
    )
}