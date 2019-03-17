package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.StandIn
import com.molikuner.vpapp.data.remote.types.StandInResponse
import com.molikuner.vpapp.types.ClazzDiscriminator
import com.molikuner.vpapp.types.LessonDiscriminator
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.serializer
import com.molikuner.vpapp.util.use
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.IntDescriptor

@Serializer(forClass = StandIn::class)
object StandInSerializer : KSerializer<StandIn> {

    override val descriptor: SerialDescriptor = object : SerialArrayClassDescImpl("StandIn") {
        init {
            addElement(StandIn::id, 0, UUID.descriptor)
            addElement("remoteType", 1, IntDescriptor)
            addElement(StandIn::day, 3, Time.Day.descriptor)
            addElement(StandIn::message, 4)
            addElement(StandIn::teacher, 5)
            addElement(StandIn::subject, 6)
            addElement(StandIn::clazz, 7, ClazzDiscriminator.descriptor)
            addElement(StandIn::lesson, 8, LessonDiscriminator.descriptor)
            addElement(StandIn::room, 9)
            addElement(StandIn::origTeacher, 10)
            addElement(StandIn::origSubject, 11)
            addElement(StandIn::isEliminated, 12)
        }
    }

    override fun deserialize(decoder: Decoder): StandIn {
        return decoder.use(descriptor) {
            StandIn.Impl(
                id = decodeSerializableElement(0, UUID.serializer()).also {
                    if (decodeIntElement(1) != 0) throw IllegalArgumentException("trying to parse a motd as standIn")
                },
                day = decodeSerializableElement(3, Time.Day.serializer()),
                message = decodeNullableStringElement(4),
                teacher = decodeNullableStringElement(5),
                subject = decodeNullableStringElement(6),
                clazz = decodeNullableSerializableElement(7, ClazzDiscriminator.serializer()),
                lesson = decodeNullableSerializableElement(8, LessonDiscriminator.serializer()),
                room = decodeNullableStringElement(9),
                origTeacher = decodeNullableStringElement(10),
                origSubject = decodeNullableStringElement(11),
                isEliminated = decodeBooleanElement(12)
            )
        }
    }

    override fun serialize(encoder: Encoder, obj: StandIn) {
        return encoder.use(descriptor) {
            encodeSerializableElement(0, UUID.serializer(), obj.id)
            encodeIntElement(1, StandInResponse.STAND_IN)
            encodeSerializableElement(3, Time.Day.serializer(), obj.day)
            encodeNullableStringElement(4, obj.message)
            encodeNullableStringElement(5, obj.teacher)
            encodeNullableStringElement(6, obj.subject)
            encodeNullableSerializableElement(7, obj.clazz, ClazzDiscriminator.serializer())
            encodeNullableSerializableElement(8, obj.lesson, LessonDiscriminator.serializer())
            encodeNullableStringElement(9, obj.room)
            encodeNullableStringElement(10, obj.origTeacher)
            encodeNullableStringElement(11, obj.origSubject)
            encodeBooleanElement(12, obj.isEliminated)
        }
    }
}
