package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Decoder
import kotlinx.serialization.SerialDescriptor

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
