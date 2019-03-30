package com.molikuner.vpapp.types

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializable(with = ClazzDiscriminator.Companion::class)
data class ClazzDiscriminator(
    val discriminator: String
) {
    init {
        // TODO check format
    }

    override fun toString() = discriminator

    @Serializer(forClass = ClazzDiscriminator::class)
    companion object {
        override val descriptor: SerialDescriptor = StringDescriptor.withName("ClazzDiscriminator")

        override fun deserialize(decoder: Decoder): ClazzDiscriminator {
            return ClazzDiscriminator(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: ClazzDiscriminator) {
            encoder.encodeString(obj.toString())
        }
    }

    object Adapter : ColumnAdapter<ClazzDiscriminator, String> {
        override fun decode(databaseValue: String): ClazzDiscriminator {
            return ClazzDiscriminator(databaseValue)
        }

        override fun encode(value: ClazzDiscriminator): String {
            return value.toString()
        }
    }
}
