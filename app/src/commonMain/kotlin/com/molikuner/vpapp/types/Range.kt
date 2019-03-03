package com.molikuner.vpapp.types

import com.molikuner.vpapp.util.simpleTry
import kotlinx.serialization.Serializable

@Serializable
sealed class Range<T : Time> (
    open val begin: T,
    open val end: T
) {
    @Serializable
    data class Day(
        override val begin: Time.Day,
        override val end: Time.Day
    ) : Range<Time.Day>(begin, end)

    @Serializable
    data class Timestamp(
        override val begin: Time.Timestamp,
        override val end: Time.Timestamp
    ) : Range<Time.Timestamp>(begin, end)

    // TODO write serializer
    companion object {
        operator fun <T : Time> invoke(begin: T, end: T): Range<out Time> {
            simpleTry("Can not create Range of two different Time types", ::IllegalArgumentException) {
                return if (begin is Time.Day) {
                    Range.Day(begin, end as Time.Day)
                } else {
                    Range.Timestamp(begin as Time.Timestamp, end as Time.Timestamp)
                }
            }
        }
    }
}
