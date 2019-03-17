package com.molikuner.vpapp.types

import com.molikuner.vpapp.util.simpleTry
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializable(with = Range.Companion::class)
sealed class Range<T : Time>(
    open val begin: T,
    open val end: T
) {
    @Serializable(with = Range.Day.Companion::class)
    data class Day(
        override val begin: Time.Day,
        override val end: Time.Day
    ) : Range<Time.Day>(begin, end) {

        @Serializer(forClass = Day::class)
        companion object : KSerializer<Day> {
            operator fun invoke(input: String): Day {
                // TODO check format
                return decode(input, Time.Day.Companion::invoke, ::Day)
            }

            override val descriptor: SerialDescriptor
                get() = StringDescriptor.withName("Range.Day")

            override fun deserialize(decoder: Decoder): Day {
                return Day(decoder.decodeString())
            }

            override fun patch(decoder: Decoder, old: Day): Day {
                return Day.deserialize(decoder)
            }

            override fun serialize(encoder: Encoder, obj: Day) {
                return encoder.encodeString(obj.toString())
            }
        }
    }

    @Serializable(with = Range.Timestamp.Companion::class)
    data class Timestamp(
        override val begin: Time.Timestamp,
        override val end: Time.Timestamp
    ) : Range<Time.Timestamp>(begin, end) {

        @Serializer(forClass = Timestamp::class)
        companion object : KSerializer<Timestamp> {
            operator fun invoke(input: String): Timestamp {
                // TODO check format
                return decode(input, Time.Timestamp.Companion::invoke, ::Timestamp)
            }

            override val descriptor: SerialDescriptor
                get() = StringDescriptor.withName("Range.Timestamp")

            override fun deserialize(decoder: Decoder): Timestamp {
                return Timestamp(decoder.decodeString())
            }

            override fun patch(decoder: Decoder, old: Timestamp): Timestamp {
                return deserialize(decoder)
            }

            override fun serialize(encoder: Encoder, obj: Timestamp) {
                return encoder.encodeString(obj.toString())
            }
        }
    }

    @Serializer(forClass = Range::class)
    companion object : KSerializer<Range<*>> {
        operator fun <T : Time> invoke(begin: T, end: T): Range<out Time> {
            simpleTry("Can not create Range of two different Time types", ::IllegalArgumentException) {
                return if (begin is Time.Day) {
                    Range.Day(begin, end as Time.Day)
                } else {
                    Range.Timestamp(begin as Time.Timestamp, end as Time.Timestamp)
                }
            }
        }

        private inline fun <T : Time, R : Range<T>> decode(
            input: String,
            time: (String) -> T,
            constructor: (T, T) -> R
        ): R {
            if (input.contains('+')) {
                input.split("+-").also {
                    val middle = time(it[0])
                    val range = time(it[1])
                    return constructor(
                        middle - range,
                        middle + range
                    )
                }
            } else {
                input.split('-').also {
                    return constructor(
                        time(it[0]),
                        time(it[1])
                    )
                }
            }
        }

        operator fun invoke(input: String): Range<*> {
            // TODO check format
            return if (input.contains('T')) Timestamp(input) else Day(input)
        }

        override val descriptor: SerialDescriptor
            get() = StringDescriptor.withName("Range")

        override fun deserialize(decoder: Decoder): Range<*> {
            return Range(decoder.decodeString())
        }

        override fun patch(decoder: Decoder, old: Range<*>): Range<*> {
            return Range.deserialize(decoder)
        }

        override fun serialize(encoder: Encoder, obj: Range<*>) {
            return encoder.encodeString(encoder.toString())
        }
    }
}
