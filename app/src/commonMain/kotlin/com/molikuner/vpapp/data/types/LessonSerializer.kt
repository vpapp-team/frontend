package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Lesson
import com.molikuner.vpapp.data.util.serialization.EnumNumberSerializer
import com.molikuner.vpapp.data.util.serialization.SerialArrayClassDescImpl
import com.molikuner.vpapp.data.util.serialization.serializer
import com.molikuner.vpapp.data.util.serialization.use
import com.molikuner.vpapp.types.ClazzDiscriminator
import com.molikuner.vpapp.types.LessonDiscriminator
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.EnumSerializer
import kotlinx.serialization.internal.IntDescriptor

@Serializer(forClass = Lesson::class)
class LessonSerializer(
    private val master: UUID
) : KSerializer<Lesson> {
    override val descriptor: SerialDescriptor
        get() = LessonSerializer.descriptor

    companion object {
        val descriptor = object : SerialArrayClassDescImpl("Lesson") {
            init {
                addElement(Lesson::id, 0, UUID.descriptor)
                addElement(Lesson::day, 1, IntDescriptor)
                addElement(Lesson::lesson, 2, LessonDiscriminator.descriptor)
                addElement(Lesson::room, 3)
                addElement(Lesson::teacher, 3)
                addElement(Lesson::subject, 4)
                addElement(Lesson::clazz, 5, ClazzDiscriminator.descriptor)
                addElement(Lesson::length, 6, IntDescriptor)
                addElement(Lesson::regularity, 7, IntDescriptor)
            }
        }
    }

    override fun deserialize(decoder: Decoder): Lesson {
        return decoder.use(descriptor) {
            Lesson.Impl(
                id = decodeSerializableElement(0, UUID.serializer()),
                master = master,
                day = decodeSerializableElement(1, EnumNumberSerializer(Time.WEEKDAYS::class)),
                lesson = decodeSerializableElement(2, LessonDiscriminator.serializer()),
                room = decodeNullableStringElement(3),
                teacher = decodeStringElement(4),
                subject = decodeStringElement(5),
                clazz = decodeSerializableElement(6, ClazzDiscriminator.serializer()),
                length = decodeIntElement(7),
                regularity = decodeSerializableElement(8, EnumSerializer(LessonRegularity::class))
            )
        }
    }

    override fun patch(decoder: Decoder, old: Lesson): Lesson {
        return deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, obj: Lesson) {
        return encoder.use(descriptor) {
            encodeSerializableElement(0, UUID.serializer(), obj.id)
            encodeSerializableElement(1, EnumNumberSerializer(Time.WEEKDAYS::class), obj.day)
            encodeSerializableElement(2, LessonDiscriminator.serializer(), obj.lesson)
            encodeNullableStringElement(3, obj.room)
            encodeStringElement(4, obj.teacher)
            encodeStringElement(5, obj.subject)
            encodeSerializableElement(6, ClazzDiscriminator.serializer(), obj.clazz)
            encodeIntElement(7, obj.length)
            encodeSerializableElement(8, EnumSerializer(LessonRegularity::class), obj.regularity)
        }
    }
}
