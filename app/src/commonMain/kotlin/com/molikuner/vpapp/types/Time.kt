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
data class Time internal constructor(
    val representsDay: Boolean,
    val unix: Long
) {
    constructor(input: String): this("T" in input, if ("T" in input) input.drop(2).toLong() else input.drop(1).toLong()) {
        // TODO check format
    }

    override fun toString(): String {
        return "D${if (representsDay) "" else "T"}${if (representsDay) unix / 1000 * 60 * 60 * 24 else unix}"
    }

    @Serializer(forClass = Time::class)
    companion object : KSerializer<Time> {
        override val descriptor: SerialDescriptor = StringDescriptor.withName("Time")

        override fun deserialize(decoder: Decoder): Time {
            return Time(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: Time) {
            return encoder.encodeString(obj.toString())
        }
    }

    object Adapter: ColumnAdapter<Time, String> {
        override fun decode(databaseValue: String): Time {
            return Time(input = databaseValue)
        }

        override fun encode(value: Time): String {
            return value.toString()
        }
    }

    enum class DAYS {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        val id: Number
            get() = this.ordinal
    }

    enum class WEEKDAYS {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;

        val id: Number
            get() = this.ordinal
    }
}