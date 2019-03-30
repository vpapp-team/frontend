package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.data.local.Lesson
import com.molikuner.vpapp.data.local.Timetable
import com.molikuner.vpapp.data.types.LessonSerializer
import com.molikuner.vpapp.data.types.TimetableTypes
import com.molikuner.vpapp.data.util.serialization.EnumNumberSerializer
import com.molikuner.vpapp.data.util.serialization.SerialArrayClassDescImpl
import com.molikuner.vpapp.data.util.serialization.serializer
import com.molikuner.vpapp.data.util.serialization.use
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.ArrayListClassDesc
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.internal.IntDescriptor

@Serializable(with = RemoteTimetable.Companion::class)
data class RemoteTimetable(
    val id: UUID,
    val type: TimetableTypes,
    val master: String,
    val activation: Time,
    val lessons: List<Lesson>
) {
    val timetable = Timetable.Impl(id, type, master, activation)

    init {
        checkDataIntegrity()
    }

    fun checkDataIntegrity() {
        lessons.forEach {
            if (it.master != id) {
                throw IllegalStateException(
                    "Current Timetable object ($id) has invalid data (${it.master})"
                )
            }
        }
    }

    @Serializer(forClass = RemoteTimetable::class)
    companion object {
        override val descriptor: SerialDescriptor
            get() = object : SerialArrayClassDescImpl("RemoteTimetable") {
                init {
                    addElement(RemoteTimetable::id, 0, UUID.descriptor)
                    addElement(RemoteTimetable::type, 1, IntDescriptor)
                    addElement(RemoteTimetable::master, 2)
                    addElement(RemoteTimetable::activation, 3, Time.descriptor)
                    addElement(RemoteTimetable::lessons, 4, ArrayListClassDesc(LessonSerializer.descriptor))
                }
            }

        override fun deserialize(decoder: Decoder): RemoteTimetable {
            return decoder.use(descriptor) {
                val id: UUID
                return@use RemoteTimetable(
                    id = decodeSerializableElement(0, UUID.serializer()).also {
                        id = it
                    },
                    type = decodeSerializableElement(1, EnumNumberSerializer(TimetableTypes::class)),
                    master = decodeStringElement(2),
                    activation = decodeSerializableElement(3, Time.serializer()),
                    lessons = decodeSerializableElement(5, ArrayListSerializer(LessonSerializer(id)))
                )
            }
        }

        override fun patch(decoder: Decoder, old: RemoteTimetable): RemoteTimetable {
            return deserialize(decoder)
        }

        override fun serialize(encoder: Encoder, obj: RemoteTimetable) {
            return encoder.use(descriptor) {
                encodeSerializableElement(0, UUID.serializer(), obj.id)
                encodeSerializableElement(1, EnumNumberSerializer(TimetableTypes::class), obj.type)
                encodeStringElement(2, obj.master)
                encodeSerializableElement(3, Time.serializer(), obj.activation)
                encodeSerializableElement(5, ArrayListSerializer(LessonSerializer(obj.id)), obj.lessons)
            }
        }
    }
}
