package com.molikuner.vpapp.data.types

enum class LessonRegularity {
    ALWAYS, UNEVEN_WEEK, EVEN_WEEK;

    val id: Number
        get() = this.ordinal
}
