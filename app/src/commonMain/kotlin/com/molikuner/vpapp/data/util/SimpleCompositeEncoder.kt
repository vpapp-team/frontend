package com.molikuner.vpapp.util

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PrimitiveKind
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerialKind
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.decodeNullable
import kotlinx.serialization.encodeNullable
import kotlinx.serialization.internal.BooleanSerializer
import kotlinx.serialization.internal.ByteSerializer
import kotlinx.serialization.internal.CharSerializer
import kotlinx.serialization.internal.DoubleSerializer
import kotlinx.serialization.internal.FloatSerializer
import kotlinx.serialization.internal.IntSerializer
import kotlinx.serialization.internal.LongSerializer
import kotlinx.serialization.internal.ShortSerializer
import kotlinx.serialization.internal.StringSerializer
import kotlinx.serialization.internal.UnitSerializer

class SimpleCompositeEncoder(
    private val descriptor: SerialDescriptor,
    private val orig: CompositeEncoder
) :
    CompositeEncoder by orig {

    override fun encodeBooleanElement(desc: SerialDescriptor, index: Int, value: Boolean) =
        orig.encodeBooleanElement(desc, skipToElement(index), value)

    fun encodeBooleanElement(index: Int, value: Boolean) =
        encodeBooleanElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableBooleanElement(
        index: Int,
        value: Boolean?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, BooleanSerializer, desc)

    override fun encodeByteElement(desc: SerialDescriptor, index: Int, value: Byte) =
        orig.encodeByteElement(desc, skipToElement(index), value)

    fun encodeByteElement(index: Int, value: Byte) =
        encodeByteElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableByteElement(
        index: Int,
        value: Byte,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, ByteSerializer, desc)

    override fun encodeCharElement(desc: SerialDescriptor, index: Int, value: Char) =
        orig.encodeCharElement(desc, skipToElement(index), value)

    fun encodeCharElement(index: Int, value: Char) =
        encodeCharElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableCharElement(
        index: Int,
        value: Char?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, CharSerializer, desc)

    override fun encodeDoubleElement(desc: SerialDescriptor, index: Int, value: Double) =
        orig.encodeDoubleElement(desc, skipToElement(index), value)

    fun encodeDoubleElement(index: Int, value: Double) =
        encodeDoubleElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableDoubleElement(
        index: Int,
        value: Double?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, DoubleSerializer, desc)

    override fun encodeFloatElement(desc: SerialDescriptor, index: Int, value: Float) =
        orig.encodeFloatElement(desc, skipToElement(index), value)

    fun encodeFloatElement(index: Int, value: Float) =
        encodeFloatElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableFloatElement(
        index: Int,
        value: Float?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, FloatSerializer, desc)

    override fun encodeIntElement(desc: SerialDescriptor, index: Int, value: Int) =
        orig.encodeIntElement(desc, skipToElement(index), value)

    fun encodeIntElement(index: Int, value: Int) =
        encodeIntElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableIntElement(
        index: Int,
        value: Int?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, IntSerializer, desc)

    override fun encodeLongElement(desc: SerialDescriptor, index: Int, value: Long) =
        orig.encodeLongElement(desc, skipToElement(index), value)

    fun encodeLongElement(index: Int, value: Long) =
        encodeLongElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableLongElement(
        index: Int,
        value: Long?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, LongSerializer, desc)

    override fun <T : Any> encodeNullableSerializableElement(
        desc: SerialDescriptor,
        index: Int,
        serializer: SerializationStrategy<T>,
        value: T?
    ) = orig.encodeNullableSerializableElement(desc, skipToElement(index), serializer.let {
        if (it.descriptor.isNullable) it else it.nullable()
    }, value)

    fun <T : Any> encodeNullableSerializableElement(
        index: Int,
        value: T?,
        serializer: SerializationStrategy<T>
    ) =
        encodeNullableSerializableElement(descriptor.getElementDescriptor(index), index, serializer, value)

    fun <T : Any> encodeNullableSerializableElement(
        index: Int,
        value: T?,
        serializer: SerializationStrategy<T>,
        desc: SerialDescriptor
    ) = encodeNullableSerializableElement(desc, index, serializer, value)

    override fun <T> encodeSerializableElement(
        desc: SerialDescriptor,
        index: Int,
        serializer: SerializationStrategy<T>,
        value: T
    ) = orig.encodeSerializableElement(desc, skipToElement(index), serializer, value)

    fun <T> encodeSerializableElement(index: Int, serializer: SerializationStrategy<T>, value: T) =
        encodeSerializableElement(descriptor.getElementDescriptor(index), index, serializer, value)

    override fun encodeShortElement(desc: SerialDescriptor, index: Int, value: Short) =
        orig.encodeShortElement(desc, skipToElement(index), value)

    fun encodeShortElement(index: Int, value: Short) =
        encodeShortElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableShortElement(
        index: Int,
        value: Short?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, ShortSerializer, desc)

    override fun encodeStringElement(desc: SerialDescriptor, index: Int, value: String) =
        orig.encodeStringElement(desc, skipToElement(index), value)

    fun encodeStringElement(index: Int, value: String) =
        encodeStringElement(descriptor.getElementDescriptor(index), index, value)

    fun encodeNullableStringElement(
        index: Int,
        value: String?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, StringSerializer, desc)

    override fun encodeUnitElement(desc: SerialDescriptor, index: Int) =
        orig.encodeUnitElement(desc, skipToElement(index))

    fun encodeUnitElement(index: Int) = encodeUnitElement(descriptor.getElementDescriptor(index), index)

    fun encodeNullableUnitElement(
        index: Int,
        value: Unit?,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        encodeNullableSerializableElement(index, value, UnitSerializer, desc)

    var currentIndex = 0
    private fun skipToElement(index: Int): Int {
        val current = currentIndex++
        if (index > current) {
            orig.encodeNullableSerializableElement(
                SkippingIndexSerializer.descriptor,
                current,
                SkippingIndexSerializer,
                null
            ).also {
                return skipToElement(index)
            }
        }
        return current
    }

    override fun equals(other: Any?) = orig == other

    override fun hashCode() = orig.hashCode()

    override fun toString() = "Simple$orig"
}

private object SkippingIndexSerializer : KSerializer<Any?> {
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

fun CompositeEncoder.simple(descriptor: SerialDescriptor): SimpleCompositeEncoder =
    SimpleCompositeEncoder(descriptor, this)
