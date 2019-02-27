package com.molikuner.vpapp.data.util

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.enumClassName
import kotlinx.serialization.enumMembers
import kotlinx.serialization.internal.IntDescriptor
import kotlin.reflect.KClass

class EnumNumberSerializer<T : Enum<T>>(
    private val serializableClass: KClass<T>
) : KSerializer<T> {
    override val descriptor: SerialDescriptor = IntDescriptor

    override fun deserialize(decoder: Decoder): T {
        return serializableClass.enumMembers().let {
            val index = decoder.decodeInt()
            if (it.size < index || index < 0) throw IllegalArgumentException("unknown index $index for enum ${serializableClass.enumClassName()}")
            it[index]
        }
    }

    override fun serialize(encoder: Encoder, obj: T) {
        if (obj !in serializableClass.enumMembers()) throw IllegalArgumentException("unknown object $obj for enum ${serializableClass.enumClassName()}")
        encoder.encodeInt(obj.ordinal)
    }
}

// fun <T: Enum<T>> KClass<T>.valueOf(index: Int): T {
//    if using it, add an exception for wrong index?
//    return enumMembers()[index]
// }
