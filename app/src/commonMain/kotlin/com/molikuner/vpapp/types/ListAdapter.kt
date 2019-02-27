package com.molikuner.vpapp.types

import com.squareup.sqldelight.ColumnAdapter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class ListAdapter<T : Any>(private val serializer: KSerializer<T>) : ColumnAdapter<List<T>, String> {
    override fun decode(databaseValue: String): List<T> {
        return Json.parse(serializer.list, databaseValue)
    }

    override fun encode(value: List<T>): String {
        return Json.stringify(serializer.list, value)
    }
}
