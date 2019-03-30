package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.encodeNullable

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
