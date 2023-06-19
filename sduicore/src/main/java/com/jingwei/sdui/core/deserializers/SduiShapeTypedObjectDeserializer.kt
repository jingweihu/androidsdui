package com.jingwei.sdui.core.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.jingwei.sdui.core.component.attribute.SduiShape
import com.jingwei.sdui.core.component.attribute.ShapeType
import com.jingwei.sdui.core.deserializers.base.SduiTypedObjectDeserializer

class SduiShapeTypedObjectDeserializer: SduiTypedObjectDeserializer<SduiShape,  ShapeType>(ShapeType::class.java) {
    override fun parse(
        json: JsonElement,
        type: ShapeType,
        context: JsonDeserializationContext
    ): SduiShape {
        return when(type) {
            ShapeType.ROUNDED_CORNER ->  context.deserialize<SduiShape.RoundedCornerShape>(json.asJsonObject, SduiShape.RoundedCornerShape::class.java)
            ShapeType.CIRCLE ->  context.deserialize<SduiShape.CircleShape>(json.asJsonObject, SduiShape.CircleShape::class.java)
            else -> throw java.lang.IllegalArgumentException("$type has not been supported")
        }
    }

}