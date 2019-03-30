package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.LessonRange
import com.molikuner.vpapp.data.util.serialization.serializer
import com.molikuner.vpapp.data.util.serialization.use
import com.molikuner.vpapp.types.LessonDiscriminator
import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializer(forClass = LessonRange::class)
object LessonRangeSerializer : KSerializer<LessonRange> {
    override val descriptor: SerialDescriptor
        get() = object : SerialClassDescImpl("LessonRange") {
            init {
                addElement(LessonRange::discriminator.name)
                addElement(LessonRange::time.name)
            }
        }

    override fun deserialize(decoder: Decoder): LessonRange {
        lateinit var discriminator: LessonDiscriminator
        lateinit var time: String

        val objDecoder = decoder.beginStructure(descriptor)
        loop@ while (true) {
            when (val i = objDecoder.decodeElementIndex(descriptor)) {
                CompositeDecoder.READ_DONE -> break@loop
                0 -> discriminator =
                    objDecoder.decodeSerializableElement(descriptor, i, LessonDiscriminator.serializer())
                1 -> time = objDecoder.decodeStringElement(descriptor, i)
                else -> throw SerializationException("Unknown index $i")
            }
        }

        return LessonRange.Impl(
            discriminator = discriminator,
            time = time
        )
    }

    override fun patch(decoder: Decoder, old: LessonRange): LessonRange {
        class MutableLessonRange : LessonRange {
            override lateinit var discriminator: LessonDiscriminator
            val hasDiscriminator: Boolean
                get() = ::discriminator.isInitialized

            override lateinit var time: String
            val hasTime: Boolean
                get() = ::time.isInitialized
        }

        val mlr = MutableLessonRange()

        val objDecoder = decoder.beginStructure(descriptor)
        loop@ while (true) {
            when (val i = objDecoder.decodeElementIndex(descriptor)) {
                CompositeDecoder.READ_DONE -> break@loop
                0 -> mlr.discriminator =
                    objDecoder.decodeSerializableElement(descriptor, i, LessonDiscriminator.serializer())
                1 -> mlr.time = objDecoder.decodeStringElement(descriptor, i)
                else -> throw SerializationException("Unknown index $i")
            }
        }

        return LessonRange.Impl(
            discriminator = if (mlr.hasDiscriminator) mlr.discriminator else old.discriminator,
            time = if (mlr.hasTime) mlr.time else old.time
        )
    }

    override fun serialize(encoder: Encoder, obj: LessonRange) {
        encoder.use(descriptor) {
            encodeSerializableElement(descriptor, 0, LessonDiscriminator.serializer(), obj.discriminator)
            encodeStringElement(descriptor, 1, obj.time)
        }
    }
}
