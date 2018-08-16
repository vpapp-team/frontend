package com.molikuner.types

import android.arch.persistence.room.Entity
import android.arch.persistence.room.TypeConverter
import java.util.*

@Entity
class Time(time: Long = System.currentTimeMillis(), private val representsDay: Boolean = false) : Date(time) {
    companion object {
        private val TIME_REGEX = """^DT?[0-9]+$""".toRegex(RegexOption.IGNORE_CASE)
        val DAY: Long = 86400000L
        val HOUR: Long = 3600000L

        fun of(time: String): Time {
            if (!Time.validate(time)) throw IllegalArgumentException("invalid time: String")
            val representsDay: Boolean = !time.startsWith("DT")
            val date: Long = if (representsDay) {
                time.substring(1).toLong()
            } else {
                time.substring(2).toLong() * Time.DAY
            }
            return Time(date, representsDay)
        }

        @TypeConverter
        fun toString(time: Time?): String? = time?.toString()

        @TypeConverter
        fun toTime(time: String?): Time? = if (time != null) Time.of(time) else null

        private fun validate(time: String): Boolean = time.matches(Time.TIME_REGEX)
    }

    override fun toString(): String {
        return "D${if (this.representsDay) "${this.time / Time.DAY}" else "T${this.time}"}"
    }
}