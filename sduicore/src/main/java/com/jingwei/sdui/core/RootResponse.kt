package com.jingwei.sdui.core

import com.google.gson.JsonElement
import com.jingwei.jimu.components.attributes.SduiRenderLocation

data class RootResponse(
    val renderLocation: SduiRenderLocation,
    val content: JsonElement,
    val version: Int
)