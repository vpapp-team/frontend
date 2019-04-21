package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Decoder
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.decode

inline fun <reified T> Decoder.use(
    descriptor: SerialDescriptor,
    elementsCount: Int = descriptor.elementsCount,
    block: SimpleCompositeDecoder.() -> T
): T {
    return this.beginStructure(descriptor).simple(descriptor).let {
        it.block().apply {
            it.skipToEnd(elementsCount)
            it.endStructure(descriptor)
        }
    }
}

fun <T : Any> Decoder.decodeNullable(deserializer: DeserializationStrategy<T>): T? =
    if (decodeNotNullMark()) decode(deserializer) else decodeNull()

fun <T : Any> Decoder.updateNullable(
    deserializer: DeserializationStrategy<T>,
    old: T?,
    nullableDeserializer: DeserializationStrategy<T?> = deserializer.nullable()
): T? = when {
    old == null -> nullableDeserializer.deserialize(this)
    decodeNotNullMark() -> updateSerializableValue(deserializer, old)
    else -> decodeNull().let { old }
}
