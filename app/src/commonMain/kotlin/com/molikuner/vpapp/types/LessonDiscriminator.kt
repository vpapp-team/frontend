package com.molikuner.vpapp.types

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializable
data class LessonDiscriminator(
    val discriminator: String
) {
    val excpetion: Boolean = true

    init {
        // TODO exception
        // TODO check format
    }

    override fun toString() = discriminator

    @Serializer(forClass = LessonDiscriminator::class)
    companion object : KSerializer<LessonDiscriminator> {
        override val descriptor: SerialDescriptor = StringDescriptor.withName("LessonDiscriminator")

        override fun deserialize(decoder: Decoder): LessonDiscriminator {
            return LessonDiscriminator(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: LessonDiscriminator) {
            encoder.encodeString(obj.toString())
        }
    }

    object Adapter : ColumnAdapter<LessonDiscriminator, String> {
        override fun decode(databaseValue: String): LessonDiscriminator {
            return LessonDiscriminator(databaseValue)
        }

        override fun encode(value: LessonDiscriminator): String {
            return value.toString()
        }
    }
}
