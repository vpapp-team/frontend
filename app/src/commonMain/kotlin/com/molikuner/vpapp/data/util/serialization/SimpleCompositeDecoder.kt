package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialDescriptor
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

class SimpleCompositeDecoder(
    private val descriptor: SerialDescriptor,
    private val orig: CompositeDecoder
) :
    CompositeDecoder by orig {

    override fun decodeBooleanElement(desc: SerialDescriptor, index: Int) =
        orig.decodeBooleanElement(desc, skipToElement(index))

    fun decodeBooleanElement(index: Int) = decodeBooleanElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableBooleanElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, BooleanSerializer, desc)

    override fun decodeByteElement(desc: SerialDescriptor, index: Int) =
        orig.decodeByteElement(desc, skipToElement(index))

    fun decodeByteElement(index: Int) = decodeByteElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableByteElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, ByteSerializer, desc)

    override fun decodeCharElement(desc: SerialDescriptor, index: Int) =
        orig.decodeCharElement(desc, skipToElement(index))

    fun decodeCharElement(index: Int) = decodeCharElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableCharElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, CharSerializer, desc)

    override fun decodeDoubleElement(desc: SerialDescriptor, index: Int) =
        orig.decodeDoubleElement(desc, skipToElement(index))

    fun decodeDoubleElement(index: Int) = decodeDoubleElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableDoubleElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, DoubleSerializer, desc)

    override fun decodeFloatElement(desc: SerialDescriptor, index: Int) =
        orig.decodeFloatElement(desc, skipToElement(index))

    fun decodeFloatElement(index: Int) = decodeFloatElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableFloatElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, FloatSerializer, desc)

    override fun decodeIntElement(desc: SerialDescriptor, index: Int) =
        orig.decodeIntElement(desc, skipToElement(index))

    fun decodeIntElement(index: Int) = decodeIntElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableIntElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, IntSerializer, desc)

    override fun decodeLongElement(desc: SerialDescriptor, index: Int) =
        orig.decodeLongElement(desc, skipToElement(index))

    fun decodeLongElement(index: Int) = decodeLongElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableLongElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, LongSerializer, desc)

    override fun <T : Any> decodeNullableSerializableElement(
        desc: SerialDescriptor,
        index: Int,
        deserializer: DeserializationStrategy<T?>
    ) = orig.decodeNullableSerializableElement(desc, skipToElement(index), deserializer)

    fun <T : Any> decodeNullableSerializableElement(
        index: Int,
        deserializer: DeserializationStrategy<T?>
    ) =
        decodeNullableSerializableElement(descriptor.getElementDescriptor(index), index, deserializer)

    fun <T : Any> decodeNullableSerializableElement(
        index: Int,
        deserializer: DeserializationStrategy<T>,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) = decodeNullableSerializableElement(desc, index, deserializer.nullable())

    override fun <T> decodeSerializableElement(
        desc: SerialDescriptor,
        index: Int,
        deserializer: DeserializationStrategy<T>
    ) = orig.decodeSerializableElement(desc, skipToElement(index), deserializer)

    fun <T> decodeSerializableElement(index: Int, deserializer: DeserializationStrategy<T>) =
        decodeSerializableElement(descriptor.getElementDescriptor(index), index, deserializer)

    override fun decodeShortElement(desc: SerialDescriptor, index: Int) =
        orig.decodeShortElement(desc, skipToElement(index))

    fun decodeShortElement(index: Int) = decodeShortElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableShortElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, ShortSerializer, desc)

    override fun decodeStringElement(desc: SerialDescriptor, index: Int) =
        orig.decodeStringElement(desc, skipToElement(index))

    fun decodeStringElement(index: Int) = decodeStringElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableStringElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, StringSerializer, desc)

    override fun decodeUnitElement(desc: SerialDescriptor, index: Int) =
        orig.decodeUnitElement(desc, skipToElement(index))

    fun decodeUnitElement(index: Int) = decodeUnitElement(descriptor.getElementDescriptor(index), index)

    fun decodeNullableUnitElement(
        index: Int,
        desc: SerialDescriptor = descriptor.getElementDescriptor(index)
    ) =
        decodeNullableSerializableElement(index, UnitSerializer, desc)

    override fun <T : Any> updateNullableSerializableElement(
        desc: SerialDescriptor,
        index: Int,
        deserializer: DeserializationStrategy<T?>,
        old: T?
    ) = orig.updateNullableSerializableElement(desc, skipToElement(index), deserializer, old)

    fun <T : Any> updateNullableSerializableElement(
        index: Int,
        deserializer: DeserializationStrategy<T?>,
        old: T?
    ) = updateNullableSerializableElement(descriptor.getElementDescriptor(index), index, deserializer, old)

    override fun <T> updateSerializableElement(
        desc: SerialDescriptor,
        index: Int,
        deserializer: DeserializationStrategy<T>,
        old: T
    ) = orig.updateSerializableElement(desc, skipToElement(index), deserializer, old)

    fun <T> updateSerializableElement(
        index: Int,
        deserializer: DeserializationStrategy<T?>,
        old: T?
    ) = updateSerializableElement(descriptor.getElementDescriptor(index), index, deserializer, old)

    fun skipToEnd(elementsCount: Int = descriptor.elementsCount) {
        val lastIndex = elementsCount - 1
        val skippedIndex = skipToElement(lastIndex)
        if (skippedIndex != lastIndex) return // already at end of object etc.
        orig.decodeNullableSerializableElement(
            SkippingIndexSerializer.descriptor,
            skipToElement(lastIndex),
            SkippingIndexSerializer
        )
    }

    private fun skipToElement(index: Int): Int {
        val current = decodeElementIndex(descriptor)
        if (current != CompositeDecoder.READ_DONE && index > current) {
            orig.decodeNullableSerializableElement(
                SkippingIndexSerializer.descriptor, current,
                SkippingIndexSerializer
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

fun CompositeDecoder.simple(descriptor: SerialDescriptor): SimpleCompositeDecoder =
    SimpleCompositeDecoder(descriptor, this)
