package com.molikuner.types

data class Range internal constructor(
    private val start: Time? = null,
    private val end: Time? = null
) {

    init {
        if (this.start == null && this.end == null)
            throw IllegalArgumentException("can't have infinite Range in both directions")
    }

    private val representsDay: Boolean
        get() = this.start?.representsDay ?: this.end?.representsDay ?: false

    val isInfinite: Boolean
        get() = this.start == null || this.end === null

    operator fun contains(testDate: Time): Boolean {
        val date = if (!testDate.representsDay && this.representsDay)
            ("D" + testDate.day).toTime()!!
        else testDate
        return this.start?.time ?: 0 <= date.time && date.time <= this.end?.time ?: Long.MAX_VALUE
    }

    override fun toString() =
        "${if (this.start != null) this.start.toString() else ""}-${if (this.end != null) this.end.toString() else ""}"

    companion object {
        private const val FROM_TO_REGEXP = """^(DT?)[0-9]+-(\\1[0-9]+)?$|^-(DT?)[0-9]+$"""
        private const val AROUND_REGEXP = """^(DT?)[0-9]+\\+-\\1[0-9]+$"""

        fun of(range: String): Range {
            if (validate(range)) throw IllegalArgumentException("range: '$range' has wrong format")
            val parts = range.split("""\\+?-""".toRegex())
            val first = parts[0].toTime()
            val second = parts[1].toTime()
            val isAround = "+-" in range

            return Range(
                start = if (isAround) first!!.rem(second!!) else first,
                end = if (isAround) first!!.add(second!!) else second
            )
        }

        fun until(end: Time) = Range(end = end)

        fun since(start: Time) = Range(start = start)

        fun from(start: Time) = RangeBuilder(start)

        fun around(around: Time) = RangeAroundBuilder(around)

        internal fun of(one: Time? = null, two: Time? = null, around: Boolean): Range {
            if ((one == null && two == null) || (around && (one == null || two == null))) return Range()
            if (around && one!!.representsDay != two!!.representsDay) {
                return if (one.representsDay) of(
                    one = Time.of(one.time, representsDay = false),
                    two = two,
                    around = around
                )
                else of(
                    one = one,
                    two = Time.of(two.time, representsDay = false),
                    around = around
                )
            }
            return Range(
                start = if (around) one!!.rem(two!!) else one,
                end = if (around) one!!.add(two!!) else two
            )
        }

        internal fun validate(testString: String): Boolean {
            return testString.matches(FROM_TO_REGEXP.toRegex(RegexOption.IGNORE_CASE))
                    || testString.matches(AROUND_REGEXP.toRegex(RegexOption.IGNORE_CASE))
        }

        val calendar: Range
            get() = Time.ANY.today.remDay(false, 45)..Time.ANY.today.addDay(false, 70)

        val standIns: Range
            get() = Range.around(Time.WEEK.today).by(Time.of("D2"))

        val menu: Range
            get() = Range.since(Time.ANY.yesterday)
    }
}

data class RangeBuilder(val start: Time) {
    fun to(end: Time) = Range(this.start, end)
}

data class RangeAroundBuilder(val around: Time) {
    fun by(by: Time) = Range.of(this.around, by, around = true)
}

fun String.toRange(): Range? = if (Range.validate(testString = this)) Range.of(
    range = this
) else null
