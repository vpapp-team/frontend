package com.molikuner.vpapp.util

import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.SerialDescriptor

inline fun <reified T> Decoder.use(descriptor: SerialDescriptor, block: CompositeDecoder.() -> T): T {
    return this.beginStructure(descriptor).let {
        it.block().apply {
            it.endStructure(descriptor)
        }
    }
}
