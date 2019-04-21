package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PrimitiveKind
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerialKind
import kotlinx.serialization.internal.StringSerializer

internal object SkippingIndexSerializer : KSerializer<Any?> {
    override val descriptor: SerialDescriptor = object : SerialDescriptor {
        override val elementsCount: Int get() = 0
        override val isNullable: Boolean get() = true
        override val kind: SerialKind get() = PrimitiveKind.STRING
        override val name: String get() = "NoType"

        override fun getElementIndex(name: String): Int = 0

        override fun getElementName(index: Int): String = index.toString()

        override fun isElementOptional(index: Int): Boolean = true
    }

    override fun deserialize(decoder: Decoder): Any? {
        return patch(decoder, null)
    }

    override fun patch(decoder: Decoder, old: Any?): Any? {
        return decoder.decodeNullable(StringSerializer)
    }

    override fun serialize(encoder: Encoder, obj: Any?) {
        encoder.encodeNullable(StringSerializer, null)
    }
}
