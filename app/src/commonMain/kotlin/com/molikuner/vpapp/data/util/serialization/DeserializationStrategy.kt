package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Decoder
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialDescriptor

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
        return decoder.updateNullable(this@nullable, old, this)
    }

    override fun toString(): String {
        return "Nullable${this@nullable}"
    }
}
