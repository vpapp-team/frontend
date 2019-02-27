package com.molikuner.vpapp.types

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class TimeTests {
    private val timeJson = """DT0"""

    @Test
    fun testTimeSerialization() {
        assertEquals(
            Time.Timestamp(0),
            Json.parse(Time.serializer(), timeJson),
            "parse time from json"
        )
    }
}
