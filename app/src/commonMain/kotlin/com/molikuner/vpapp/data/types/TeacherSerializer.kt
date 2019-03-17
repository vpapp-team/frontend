package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Teacher
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.use
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.ArrayListClassDesc
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.internal.StringSerializer

@Serializer(forClass = Teacher::class)
object TeacherSerializer : KSerializer<Teacher> {
    override val descriptor: SerialDescriptor
        get() = object : SerialArrayClassDescImpl("Teacher") {
            init {
                addElement(Teacher::id, 0, UUID.descriptor)
                addElement(Teacher::leftSchool, 1)
                addElement(Teacher::shorthand, 2)
                addElement(Teacher::name, 3)
                addElement(Teacher::subjects, 4, ArrayListClassDesc(StringDescriptor))
                addElement(Teacher::mail, 5, UUID.descriptor)
                addElement(Teacher::comments, 6, ArrayListClassDesc(StringDescriptor))
                addElement(Teacher::timetable, 7, ArrayListClassDesc(UUID.descriptor))
            }
        }

    override fun deserialize(decoder: Decoder): Teacher {
        return decoder.use(descriptor) {
            Teacher.Impl(
                id = decodeSerializableElement(0, UUID.serializer()),
                leftSchool = decodeBooleanElement(1),
                shorthand = decodeStringElement(2),
                name = decodeStringElement(3),
                subjects = decodeSerializableElement(4, ArrayListSerializer(StringSerializer)),
                mail = decodeSerializableElement(5, UUID.serializer()),
                comments = decodeSerializableElement(6, ArrayListSerializer(StringSerializer)),
                timetable = decodeSerializableElement(
                    ArrayListClassDesc(TimetableSerializer.descriptor),
                    7,
                    ArrayListSerializer(TimetableSerializer)
                ).map {
                    it.id
                }
            )
        }
    }

    override fun patch(decoder: Decoder, old: Teacher): Teacher {
        return deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, obj: Teacher) {
        TODO("function with return type 'kotlin.Unit' not implemented")
    }
}
