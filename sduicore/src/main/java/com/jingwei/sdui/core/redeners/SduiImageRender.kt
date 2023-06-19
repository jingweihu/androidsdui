package com.jingwei.sdui.core.redeners

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.jingwei.sdui.core.component.SduiImage
import com.jingwei.sdui.core.component.attribute.toContentScale


@Composable
fun SduiImage.render(modifier: Modifier) {
    AsyncImage(
        modifier = modifier,
        model = this.url,
        contentDescription = null,
        contentScale = this.fit.toContentScale()
    )
}
