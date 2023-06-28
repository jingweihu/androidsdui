package com.jingwei.sdui.core.deserializers.base

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement

abstract class SduiTypedObjectDeserializer<R, T : Enum<T>>(private val typeClass: Class<T>) :
    JsonDeserializer<R> {
    companion object {
        private const val TYPE_KEY = "type"
    }

    override fun deserialize(
        json: JsonElement,
        typeOfT: java.lang.reflect.Type,
        context: JsonDeserializationContext
    ): R {
        val jsonObject = json.asJsonObject
        if (!jsonObject.has(TYPE_KEY)) throw IllegalArgumentException("type is required for $json")
        val value = jsonObject.get(TYPE_KEY).asString
        val type: T = convertToEnum(value)

        return parse(json, type, context)
    }

    private fun convertToEnum(value: String): T {
        return try {
            java.lang.Enum.valueOf(typeClass, value)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("$value has not been added on client")
        }
    }

    abstract fun parse(json: JsonElement, type: T, context: JsonDeserializationContext): R
}