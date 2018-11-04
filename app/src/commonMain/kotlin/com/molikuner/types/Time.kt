package com.molikuner.types

import com.molikuner.util.Platform
import kotlin.math.absoluteValue

class Time(
    time: Long,
    internal val representsDay: Boolean
) {

    var time: Long
        private set

    init {
        this.time = time
    }

    val isWeekday: Boolean
        get() = this.weekday !in intArrayOf(SATURDAY, SUNDAY)

    val weekday: Int
        get() = (this.day + 3) % 7

    val day: Int
        get() = (this.time / DAY).toInt()

    val hour: Int
        get() = getHour(this.time)

    val min: Int
        get() = ((this.time / 60000) % 60).toInt()

    val sec: Int
        get() = ((this.time / 1000) % 60).toInt()

    operator fun inc() = addDay()

    operator fun dec() = remDay()

    operator fun plus(days: Int) = this.addDay(days = days)

    operator fun plus(time: Time) = this.add(time)

    operator fun minus(days: Int) = this.remDay(days = days)

    operator fun minus(time: Time) = this.rem(time)

    operator fun rangeTo(time: Time) = Range.from(this).to(time)

    operator fun compareTo(time: Time) = (this.time - time.time).toInt()

    fun addDay(onlyWeek: Boolean = true, days: Int = 1): Time {
        if (days != 1) {
            (0 until days.absoluteValue).forEach { this.addDay(onlyWeek) }
        } else {
            this.time = this.time + DAY
            if (onlyWeek && !this.isWeekday)
                this.addDay(onlyWeek = false, days = 7 - this.weekday)
        }
        return this
    }

    fun remDay(onlyWeek: Boolean = true, days: Int = 1): Time {
        if (days != 1) {
            (0 until days.absoluteValue).forEach { this.remDay(onlyWeek) }
        } else {
            this.time = this.time - DAY
            if (onlyWeek && !this.isWeekday)
                this.remDay(onlyWeek = false, days = this.weekday - 4)
        }
        return this
    }

    fun rem(time: Time): Time {
        this.time = this.time - time.time
        return this
    }

    fun add(time: Time): Time {
        this.time = this.time + time.time
        return this
    }

    fun matches(day: Byte, onlyWeek: Boolean = true): Boolean {
        return when (day) {
            YESTERDAY -> of().time <= this.time && this.time < of(TODAY, onlyWeek).time
            TODAY -> of(TODAY, onlyWeek).time <= this.time && this.time < of(TOMORROW, onlyWeek).time
            TOMORROW ->  of(TOMORROW, onlyWeek).time <= this.time && this.time < of(TODAY, onlyWeek).addDay(onlyWeek, days = 2).time
            else -> false
        }
    }

    infix fun isAtDay(check: Time) = this.day == check.day

    fun isBetween(
        from: Time,
        to: Time,
        includeDay: Boolean = true,
        rangeExtension: Int = if (from.representsDay || this.representsDay) 1 else 0
    ): Boolean {
        return if (from.representsDay || this.representsDay) {
            (this.representsDay || includeDay) && from.day - rangeExtension < this.day && this.day < to.day + rangeExtension
        } else {
            from.time - rangeExtension < this.time && this.time < to.time + rangeExtension
        }
    }

    companion object {
        private const val TIME_REGEX = """^DT?[0-9]+$"""
        const val YESTERDAY: Byte = 0
        const val TODAY: Byte = 1
        const val TOMORROW: Byte = 2

        const val MONDAY: Int = 0
        const val TUESDAY: Int = 1
        const val WEDNESDAY: Int = 2
        const val THURSDAY: Int = 3
        const val FRIDAY: Int = 4
        const val SATURDAY: Int = 5
        const val SUNDAY: Int = 6

        const val DAY: Long = 86400000L
        const val HOUR: Long = 3600000L

        private const val SWITCH_HOUR: Byte = 18

        fun of(time: String): Time {
            if (!validate(time)) throw IllegalArgumentException("invalid time: String")
            val representsDay = !time.startsWith("DT")
            val date = if (representsDay) {
                time.substring(1).toLong()
            } else {
                time.substring(2).toLong() * DAY
            }
            return Time(date, representsDay)
        }

        fun of(time: Long = now, representsDay: Boolean = true, onlyWeek: Boolean = false): Time {
            val x = Time(
                if (representsDay) time / DAY * DAY else time,
                representsDay
            )

            if (onlyWeek && !x.isWeekday)
                x.addDay(onlyWeek = false, days = 7 - x.weekday)

            return x
        }

        fun of(day: Byte, onlyWeek: Boolean = true): Time {
            val x = of(representsDay = true, onlyWeek = onlyWeek)
                .addDay(onlyWeek, days = day - 1)

            if (getHour() >= SWITCH_HOUR) {
                // do not add a day on weekend because this would offset it wrong
                if (!onlyWeek || (onlyWeek && x.isWeekday)) x.addDay(onlyWeek)
            }
            return x
        }

        fun of(day: Int): Time {
            val x = Time.ANY.today
            var d = x.weekday
            if (d - 1 == day || d - 2 == day) d -= 7
            return x.addDay(onlyWeek = false, days = day - d + 7)
        }

        fun getHour(time: Long = now) = ((time / HOUR) % 24).toInt()

        val now: Long
            get() = Platform.currentTimeMillis

        internal fun validate(time: String) = time.matches(TIME_REGEX.toRegex(RegexOption.IGNORE_CASE))
    }

    object ANY {
        val today: Time
            get() = Time.of(Time.TODAY, onlyWeek = false)

        val tomorrow: Time
            get() = Time.of(Time.TOMORROW, onlyWeek = false)

        val yesterday: Time
            get() = Time.of(Time.YESTERDAY, onlyWeek = false)
    }

    object WEEK {
        val today: Time
            get() = Time.of(Time.TODAY, onlyWeek = true)

        val tomorrow: Time
            get() = Time.of(Time.TOMORROW, onlyWeek = true)

        val yesterday: Time
            get() = Time.of(Time.YESTERDAY, onlyWeek = true)
    }

    override fun toString(): String {
        return "D${if (this.representsDay) "${this.time / DAY}" else "T${this.time}"}"
    }

    //fun toString(pattern: String) = SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}

fun String.toTime(): Time? = if (Time.validate(this.trim())) Time.of(
    this.trim()
) else null
