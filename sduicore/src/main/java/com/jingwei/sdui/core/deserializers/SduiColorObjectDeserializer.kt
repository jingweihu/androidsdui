package com.jingwei.sdui.core.deserializers

import com.google.gson.*
import com.jingwei.sdui.core.component.attribute.SduiColor
import java.lang.reflect.Type

class SduiColorObjectDeserializer: JsonDeserializer<SduiColor> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): SduiColor {

        return try {
            val value = json.asLong
            return SduiColor(value)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("SduiColor has not been supported on client")
        }
    }
}