package com.molikuner.vpapp.data.types

enum class TimetableTypes {
    CLAZZ, TEACHER, ROOM;

    val id: Number
        get() = this.ordinal
}