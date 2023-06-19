package com.jingwei.sdui.core.mappers

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.jingwei.sdui.core.component.attribute.SduiAbsoluteAlignment
import com.jingwei.sdui.core.attributes.SduiMainAxisAlignment
import com.jingwei.sdui.core.component.SduiComponent
import com.jingwei.sdui.core.component.attribute.*
import com.jingwei.sdui.core.deserializers.SduiColorObjectDeserializer
import com.jingwei.sdui.core.deserializers.SduiComponentTypedObjectDeserializer
import com.jingwei.sdui.core.deserializers.SduiModifierTypedObjectDeserializer
import com.jingwei.sdui.core.deserializers.SduiShapeTypedObjectDeserializer
import com.jingwei.sdui.core.deserializers.base.SduiSingleFieldEnumObjectDeserializer
import javax.inject.Inject


class SduiCoreMapper @Inject constructor(): SduiMapper {
    private val builder = GsonBuilder()

    init {
        registerEnums()
        registerParser()
    }

    private fun registerParser() {
        builder.registerTypeAdapter(SduiModifier::class.java, SduiModifierTypedObjectDeserializer())
        builder.registerTypeAdapter(SduiComponent::class.java, SduiComponentTypedObjectDeserializer())
        builder.registerTypeAdapter(SduiShape::class.java, SduiShapeTypedObjectDeserializer())
        builder.registerTypeAdapter(SduiColor::class.java, SduiColorObjectDeserializer())
    }

    private fun registerEnums() {
        builder.registerEnumAdapter<SduiCrossAxisAlignment>()
        builder.registerEnumAdapter<SduiMainAxisAlignment>()
        builder.registerEnumAdapter<SduiAbsoluteAlignment>()
        builder.registerEnumAdapter<SduiImageFit>()
    }

    override fun parseComponent(element: JsonElement): SduiComponent {
        return builder.create().fromJson(element, SduiComponent::class.java)
    }
}

inline fun <reified T : Enum<T>> GsonBuilder.registerEnumAdapter() {
    registerTypeAdapter(T::class.java, SduiSingleFieldEnumObjectDeserializer(T::class.java))
}