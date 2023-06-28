package com.jingwei.sdui.core.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.jingwei.sdui.core.component.*
import com.jingwei.sdui.core.deserializers.base.SduiTypedObjectDeserializer

class SduiComponentTypedObjectDeserializer :
    SduiTypedObjectDeserializer<SduiComponent, SduiComponentType>(SduiComponentType::class.java) {

    override fun parse(
        json: JsonElement,
        type: SduiComponentType,
        context: JsonDeserializationContext
    ): SduiComponent {
        return when (type) {
            SduiComponentType.COLUMN -> context.deserialize<SduiColumn>(
                json.asJsonObject,
                SduiColumn::class.java
            )

            SduiComponentType.ROW -> context.deserialize<SduiRow>(
                json.asJsonObject,
                SduiRow::class.java
            )

            SduiComponentType.BOX -> context.deserialize<SduiBox>(
                json.asJsonObject,
                SduiBox::class.java
            )

            SduiComponentType.IMAGE -> context.deserialize<SduiImage>(
                json.asJsonObject,
                SduiImage::class.java
            )

            SduiComponentType.TEXT -> context.deserialize<SduiText>(
                json.asJsonObject,
                SduiText::class.java
            )

            SduiComponentType.LAZY_COLUMN -> context.deserialize<SduiLazyColumn>(
                json.asJsonObject,
                SduiLazyColumn::class.java
            )

            SduiComponentType.LAZY_ROW -> context.deserialize<SduiLazyColumn>(
                json.asJsonObject,
                SduiLazyRow::class.java
            )

            SduiComponentType.SPACER -> context.deserialize(
                json.asJsonObject,
                SduiSpacer::class.java)

            else -> throw java.lang.IllegalArgumentException("${type.name} has not been supported in SduiTypedObjectDeserializer")
        }
    }
}