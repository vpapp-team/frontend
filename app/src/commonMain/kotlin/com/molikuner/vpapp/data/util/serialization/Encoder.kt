package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerializationStrategy

inline fun <reified T> Encoder.use(
    descriptor: SerialDescriptor,
    elementsCount: Int = descriptor.elementsCount,
    block: SimpleCompositeEncoder.() -> T
): T {
    return this.beginStructure(descriptor).simple(descriptor).let {
        it.block().apply {
            it.skipToEnd(elementsCount)
            it.endStructure(descriptor)
        }
    }
}

fun <T : Any> Encoder.encodeNullable(strategy: SerializationStrategy<T>, obj: T?) {
    if (obj == null) {
        encodeNull()
    } else {
        encodeNotNullMark()
        strategy.serialize(this, obj)
    }
}
