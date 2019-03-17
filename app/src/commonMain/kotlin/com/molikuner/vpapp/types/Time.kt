package com.molikuner.vpapp.types

import com.molikuner.vpapp.platform.Platform
import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializable(with = Time.Companion::class)
sealed class Time(
    open val unix: Long
) {
    abstract fun addDays(number: Long = 1): Time

    @Serializable(with = Day.Companion::class)
    data class Day(
        val day: Long
    ) : Time(day * DAY_IN_UNIX) {

        override fun toString(): String {
            return "D$day"
        }

        override fun addDays(number: Long): Time.Day {
            return this.copy(day = this.day + number)
        }

        @Serializer(forClass = Day::class)
        companion object : KSerializer<Day> {
            operator fun invoke(input: String): Day {
                return Day(input.drop(1).toLong())
            }

            override val descriptor: SerialDescriptor = StringDescriptor.withName("Time.Day")

            override fun deserialize(decoder: Decoder): Day {
                return Time(decoder.decodeString())
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
                return Time(databaseValue)
            }

            override fun encode(value: Day): String = Time.Adapter.encode(value)
        }
    }

    @Serializable(with = Timestamp.Companion::class)
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
            operator fun invoke(input: String): Timestamp {
                return Timestamp(input.drop(2).toLong())
            }

            override val descriptor: SerialDescriptor = StringDescriptor.withName("Time.Timestamp")

            override fun deserialize(decoder: Decoder): Timestamp {
                return Time(decoder.decodeString())
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
                return Time(input = databaseValue)
            }

            override fun encode(value: Timestamp): String = Time.Adapter.encode(value)
        }
    }

    @Serializer(forClass = Time::class)
    companion object : KSerializer<Time> {
        const val DAY_IN_UNIX = 86400000L
        const val HOUR_IN_UNIX = 3600000L
        const val FIVE_MIN_IN_UNIX = 300000L

        inline operator fun <reified T : Time> invoke(input: String): T {
            // TODO check format
            return if (input.contains('T')) Timestamp(input.drop(2).toLong()) as T else Day(input.drop(1).toLong()) as T
        }

        override val descriptor: SerialDescriptor = StringDescriptor.withName("Time")

        override fun deserialize(decoder: Decoder): Time {
            return Time(decoder.decodeString())
        }

        override fun patch(decoder: Decoder, old: Time): Time {
            return deserialize(decoder)
        }

        override fun serialize(encoder: Encoder, obj: Time) {
            return encoder.encodeString(obj.toString())
        }

        fun now(): Timestamp {
            return Time.Timestamp(Platform.currentTimeMillis)
        }
    }

    object Adapter : ColumnAdapter<Time, String> {
        override fun decode(databaseValue: String): Time {
            return Time(databaseValue)
        }

        override fun encode(value: Time): String {
            return value.toString()
        }
    }

    enum class DAYS { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

    enum class WEEKDAYS { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }
}

@Suppress("UNCHECKED_CAST")
operator fun <T : Time> T.minus(amount: T): T {
    return when (this) {
        is Time.Day -> this.copy(day = this.day - (amount as Time.Day).day) as T
        is Time.Timestamp -> this.copy(unix = this.unix - (amount as Time.Timestamp).unix) as T
        else -> TODO("missing branch for time while subtracting one from an other")
    }
}

@Suppress("UNCHECKED_CAST")
operator fun <T : Time> T.plus(amount: T): T {
    return when (this) {
        is Time.Day -> this.copy(day = this.day + (amount as Time.Day).day) as T
        is Time.Timestamp -> this.copy(unix = this.unix + (amount as Time.Timestamp).unix) as T
        else -> TODO("missing branch for time while adding one to an other")
    }
}
