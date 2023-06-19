package com.jingwei.sdui.core.deserializers.base

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement

class SduiSingleFieldEnumObjectDeserializer<T: Enum<T>>(private val typeClass: Class<T>): JsonDeserializer<T> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: java.lang.reflect.Type,
        context: JsonDeserializationContext
    ): T {
        val value = json.asString
        return try {
            java.lang.Enum.valueOf(typeClass, value)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("${typeClass.simpleName} has not been supported on client")
        }
    }

}