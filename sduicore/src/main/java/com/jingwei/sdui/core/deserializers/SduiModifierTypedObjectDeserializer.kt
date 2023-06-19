package com.jingwei.sdui.core.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.jingwei.sdui.core.component.attribute.*
import com.jingwei.sdui.core.deserializers.base.SduiTypedObjectDeserializer

class SduiModifierTypedObjectDeserializer: SduiTypedObjectDeserializer<SduiModifier, ModifierType>(ModifierType::class.java) {
    override fun parse(
        json: JsonElement,
        type: ModifierType,
        context: JsonDeserializationContext
    ): SduiModifier {
        return when(type) {
            ModifierType.BASIC ->  context.deserialize<SduiBaseModifier>(json.asJsonObject, SduiBaseModifier::class.java)
            ModifierType.FLEX ->  context.deserialize<SduiFlexModifier>(json.asJsonObject, SduiFlexModifier::class.java)
            ModifierType.ABSOLUTE ->  context.deserialize<SduiAbsoluteModifier>(json.asJsonObject, SduiAbsoluteModifier::class.java)
            else -> throw java.lang.IllegalArgumentException("$type has not been supported")
        }
    }
}