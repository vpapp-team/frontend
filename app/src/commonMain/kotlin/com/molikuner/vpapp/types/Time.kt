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
sealed class Time(
    open val unix: Long
) {
    abstract fun addDays(number: Long = 1): Time

    @Serializable
    data class Day(
        override val unix: Long
    ) : Time(unix) {
        override fun toString(): String {
            return "D${unix / 1000 * 60 * 60 * 24}"
        }

        override fun addDays(number: Long): Time.Day {
            return this.copy(unix = this.unix + (DAY_IN_UNIX * number))
        }

        @Serializer(forClass = Day::class)
        companion object : KSerializer<Day> {
            override val descriptor: SerialDescriptor = StringDescriptor.withName("Time.Day")

            override fun deserialize(decoder: Decoder): Day {
                return Time.decode(decoder.decodeString())
            }

            override fun patch(decoder: Decoder, old: Day): Day {
                return deserialize(decoder)
            }

            override fun serialize(encoder: Encoder, obj: Day) {
                return encoder.encodeString(obj.toString())
            }
        }

        object Adapter : ColumnAdapter<Day, String> {
            override fun decode(databaseValue: String): Day {
                return Time.decode(databaseValue)
            }

            override fun encode(value: Day): String = Time.Adapter.encode(value)
        }
    }

    @Serializable
    data class Timestamp(
        override val unix: Long
    ) : Time(unix) {
        override fun toString(): String {
            return "DT$unix"
        }

        override fun addDays(number: Long): Time.Timestamp {
            return this.copy(unix = this.unix + (DAY_IN_UNIX * number))
        }

        @Serializer(forClass = Timestamp::class)
        companion object : KSerializer<Timestamp> {
            override val descriptor: SerialDescriptor = StringDescriptor.withName("Time.Timestamp")

            override fun deserialize(decoder: Decoder): Timestamp {
                return Time.decode(decoder.decodeString())
            }

            override fun patch(decoder: Decoder, old: Timestamp): Timestamp {
                return deserialize(decoder)
            }

            override fun serialize(encoder: Encoder, obj: Timestamp) {
                return encoder.encodeString(obj.toString())
            }
        }

        object Adapter : ColumnAdapter<Timestamp, String> {
            override fun decode(databaseValue: String): Timestamp {
                return Time(input = databaseValue) as Timestamp
            }

            override fun encode(value: Timestamp): String = Time.Adapter.encode(value)
        }
    }

    @Serializer(forClass = Time::class)
    companion object : KSerializer<Time> {
        const val DAY_IN_UNIX = 86400000L

        operator fun invoke(input: String): Time {
            // TODO check format
            return if (input.contains('T')) Timestamp(input.drop(2).toLong()) else Day(input.drop(1).toLong())
        }

        private inline fun <reified T : Time> decode(input: String) = Time(input) as T

        override val descriptor: SerialDescriptor = StringDescriptor.withName("Time")

        override fun deserialize(decoder: Decoder): Time {
            return Time.decode(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: Time) {
            return encoder.encodeString(obj.toString())
        }
    }

    object Adapter : ColumnAdapter<Time, String> {
        override fun decode(databaseValue: String): Time {
            return Time.decode(databaseValue)
        }

        override fun encode(value: Time): String {
            return value.toString()
        }
    }

    enum class DAYS { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

    enum class WEEKDAYS { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }
}
