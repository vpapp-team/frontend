package com.molikuner.vpapp.util

import kotlinx.serialization.Decoder
import kotlinx.serialization.SerialDescriptor

inline fun <reified T> Decoder.use(descriptor: SerialDescriptor, block: SimpleCompositeDecoder.() -> T): T {
    return this.beginStructure(descriptor).let {
        it.simple(descriptor).block().apply {
            it.endStructure(descriptor)
        }
    }
}
