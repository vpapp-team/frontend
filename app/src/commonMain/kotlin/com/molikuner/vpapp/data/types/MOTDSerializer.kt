package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.MOTD
import com.molikuner.vpapp.data.remote.types.StandInResponse
import com.molikuner.vpapp.data.util.EnumNumberSerializer
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.use
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.ByteDescriptor
import kotlinx.serialization.internal.IntDescriptor

@Serializer(forClass = MOTD::class)
object MOTDSerializer : KSerializer<MOTD> {

    override val descriptor: SerialDescriptor = object : SerialArrayClassDescImpl("MOTD") {
        init {
            addElement(MOTD::id, 0, UUID.descriptor)
            addElement("remoteType", 1, IntDescriptor)
            addElement(MOTD::type, 2, ByteDescriptor)
            addElement(MOTD::day, 3, Time.Day.descriptor)
            addElement(MOTD::message, 4)
        }
    }

    override fun deserialize(decoder: Decoder): MOTD {
        return decoder.use(descriptor) {
            MOTD.Impl(
                id = decodeSerializableElement(0, UUID.serializer()).also {
                    if (decodeIntElement(1) != StandInResponse.MOTD) {
                        throw IllegalArgumentException("trying to parse a standIn as motd")
                    }
                },
                type = decodeSerializableElement(2, EnumNumberSerializer(MOTDTypes::class)),
                day = decodeSerializableElement(3, Time.Day.serializer()),
                message = decodeStringElement(4)
            )
        }
    }

    override fun serialize(encoder: Encoder, obj: MOTD) {
        return encoder.use(descriptor) {
            encodeSerializableElement(0, UUID.serializer(), obj.id)
            encodeIntElement(1, StandInResponse.MOTD)
            encodeSerializableElement(2, EnumNumberSerializer(MOTDTypes::class), obj.type)
            encodeSerializableElement(3, Time.Day.serializer(), obj.day)
            encodeStringElement(4, obj.message)
        }
    }
}

enum class MOTDTypes { OTHER, ABSENT_CLASSES, ABSENT_TEACHER }
