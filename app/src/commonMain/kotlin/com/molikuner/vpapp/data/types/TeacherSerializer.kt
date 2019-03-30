package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Teacher
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.data.util.serialization.SerialArrayClassDescImpl
import com.molikuner.vpapp.data.util.serialization.serializer
import com.molikuner.vpapp.data.util.serialization.use
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
            }
        }

    override fun deserialize(decoder: Decoder): Teacher {
        // may remove elementsCount override if definition of remote teacher gets changed
        return decoder.use(descriptor, 8) {
            Teacher.Impl(
                id = decodeSerializableElement(0, UUID.serializer()),
                leftSchool = decodeBooleanElement(1),
                shorthand = decodeStringElement(2),
                name = decodeStringElement(3),
                subjects = decodeSerializableElement(4, ArrayListSerializer(StringSerializer)),
                mail = decodeSerializableElement(5, UUID.serializer()),
                comments = decodeSerializableElement(6, ArrayListSerializer(StringSerializer))
            )
        }
    }

    override fun patch(decoder: Decoder, old: Teacher): Teacher {
        return deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, obj: Teacher) {
        return encoder.use(descriptor, 8) {
            encodeSerializableElement(0, UUID.serializer(), obj.id)
            encodeBooleanElement(1, obj.leftSchool)
            encodeStringElement(2, obj.shorthand)
            encodeStringElement(3, obj.name)
            encodeSerializableElement(4, ArrayListSerializer(StringSerializer), obj.subjects)
            encodeSerializableElement(5, UUID.serializer(), obj.mail)
            encodeSerializableElement(6, ArrayListSerializer(StringSerializer), obj.comments)
        }
    }
}
