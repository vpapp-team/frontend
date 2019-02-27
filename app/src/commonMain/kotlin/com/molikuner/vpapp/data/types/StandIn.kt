package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.StandIn
import com.molikuner.vpapp.types.ClazzDiscriminator
import com.molikuner.vpapp.types.LessonDiscriminator
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.use
import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer

@Serializer(forClass = StandIn::class)
object StandInSerializer : KSerializer<StandIn> {

    override val descriptor: SerialDescriptor = object : SerialArrayClassDescImpl("StandIn") {
        init {
            addElement(StandIn::id, 0, UUID.descriptor)
            addElement(StandIn::day, 3, Time.descriptor)
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
        inline fun CompositeDecoder.decodeStringElement(index: Int) =
            this.decodeStringElement(descriptor.getElementDescriptor(index), index)

        inline fun CompositeDecoder.decodeBooleanElement(index: Int) =
            this.decodeBooleanElement(descriptor.getElementDescriptor(index), index)

        inline fun <T> CompositeDecoder.decodeSerializableElement(
            index: Int,
            deserializationStrategy: DeserializationStrategy<T>
        ) = this.decodeSerializableElement(descriptor.getElementDescriptor(index), index, deserializationStrategy)

        return decoder.use(descriptor) {
            StandIn.Impl(
                id = decodeSerializableElement(0, UUID.serializer()),
                day = decodeSerializableElement(3, Time.serializer()),
                message = decodeStringElement(4),
                teacher = decodeStringElement(5),
                subject = decodeStringElement(6),
                clazz = decodeSerializableElement(7, ClazzDiscriminator.serializer()),
                lesson = decodeSerializableElement(8, LessonDiscriminator.serializer()),
                room = decodeStringElement(9),
                origTeacher = decodeStringElement(10),
                origSubject = decodeStringElement(11),
                isEliminated = decodeBooleanElement(12)
            )
        }
    }

    override fun serialize(encoder: Encoder, obj: StandIn) {
        throw UnsupportedOperationException("can not serialize ${descriptor.name}")
    }
}
