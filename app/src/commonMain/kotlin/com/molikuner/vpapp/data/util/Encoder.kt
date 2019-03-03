package com.molikuner.vpapp.util

import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor

inline fun <reified T> Encoder.use(
    descriptor: SerialDescriptor,
    block: SimpleCompositeEncoder.() -> T
): T {
    return this.beginStructure(descriptor).let {
        it.simple(descriptor).block().apply {
            it.endStructure(descriptor)
        }
    }
}
