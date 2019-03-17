package com.molikuner.vpapp.util

import kotlinx.serialization.Decoder
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.decodeNullable
import kotlinx.serialization.encodeNullable

fun <T : Any> DeserializationStrategy<T>.nullable() = object : DeserializationStrategy<T?> {
    override val descriptor: SerialDescriptor
        get() = this@nullable.descriptor.nullable()

    override fun deserialize(decoder: Decoder): T? {
        return decoder.decodeNullable(this@nullable)
    }

    override fun hashCode(): Int {
        return this@nullable.hashCode()
    }

    override fun patch(decoder: Decoder, old: T?): T? {
        return this@nullable.patch(decoder, old ?: return deserialize(decoder))
    }

    override fun toString(): String {
        return "Nullable${this@nullable}"
    }
}

fun <T : Any> SerializationStrategy<T>.nullable() = object : SerializationStrategy<T?> {
    override val descriptor: SerialDescriptor
        get() = this@nullable.descriptor.nullable()

    override fun hashCode(): Int {
        return this@nullable.hashCode()
    }

    override fun serialize(encoder: Encoder, obj: T?) {
        encoder.encodeNullable(this@nullable, obj)
    }

    override fun toString(): String {
        return "Nullable${this@nullable}"
    }
}

fun <T> KSerializer<T>.serializer() = this
