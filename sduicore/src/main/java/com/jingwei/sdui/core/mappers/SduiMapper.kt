package com.jingwei.sdui.core.mappers

import com.google.gson.JsonElement
import com.jingwei.sdui.core.component.SduiComponent

interface SduiMapper {

    fun parseComponent(element: JsonElement): SduiComponent
}