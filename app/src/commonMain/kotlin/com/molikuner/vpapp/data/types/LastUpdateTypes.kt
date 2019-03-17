package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.LastUpdate
import com.molikuner.vpapp.data.util.EnumNumberSerializer
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.serializer
import com.molikuner.vpapp.util.use
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.ByteDescriptor

@Serializer(forClass = LastUpdate::class)
object LastUpdateSerializer : KSerializer<LastUpdate> {
    override val descriptor: SerialDescriptor = object : SerialArrayClassDescImpl("LastUpdate") {
        init {
            addElement(LastUpdate::category, 0, ByteDescriptor)
            addElement(LastUpdate::lastUpdate, 1, Time.descriptor)
        }
    }

    override fun deserialize(decoder: Decoder): LastUpdate {
        return decoder.use(descriptor) {
            LastUpdate.Impl(
                category = decodeSerializableElement(0, EnumNumberSerializer(LastUpdateTypes::class)),
                lastUpdate = decodeSerializableElement(1, Time.Timestamp.serializer())
            )
        }
    }

    override fun serialize(encoder: Encoder, obj: LastUpdate) {
        return encoder.use(descriptor) {
            encodeSerializableElement(0, EnumNumberSerializer(LastUpdateTypes::class), obj.category)
            encodeSerializableElement(1, Time.serializer(), obj.lastUpdate)
        }
    }
}

enum class LastUpdateTypes { TIMETABLE, ROOM, TEACHERS, MENU, STAND_IN, CALENDAR }
