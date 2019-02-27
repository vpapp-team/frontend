package com.molikuner.vpapp.types

import com.squareup.sqldelight.ColumnAdapter

val Byte.Companion.Adapter: ColumnAdapter<Byte, Long>
    get() = object : ColumnAdapter<Byte, Long> {
        override fun decode(databaseValue: Long): Byte {
            return databaseValue.toByte()
        }

        override fun encode(value: Byte): Long {
            return value.toLong()
        }
    }
