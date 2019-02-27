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
data class UUID(
    val id: String
) {
    init {
        // TODO check format
    }

    override fun toString(): String {
        return id
    }

    @Serializer(forClass = UUID::class)
    companion object : KSerializer<UUID> {
        override val descriptor: SerialDescriptor = StringDescriptor.withName("UUID")

        override fun deserialize(decoder: Decoder): UUID {
            return UUID(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: UUID) {
            encoder.encodeString(obj.toString())
        }
    }

    object Adapter : ColumnAdapter<UUID, String> {
        override fun decode(databaseValue: String): UUID {
            return UUID(id = databaseValue)
        }

        override fun encode(value: UUID): String {
            return value.toString()
        }
    }
}