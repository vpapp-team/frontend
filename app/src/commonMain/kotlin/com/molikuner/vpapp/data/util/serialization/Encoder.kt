package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor

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
