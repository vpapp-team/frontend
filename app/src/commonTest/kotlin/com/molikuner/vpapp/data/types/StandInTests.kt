package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.StandIn
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class StandInTests {
    private val standInJson = """["uuid@random.de",0,null,"D0",null,null,null,null,null,null,null,null,false]"""

    @Test
    fun testStandInSerialization() {
        assertEquals(
            StandIn.Impl(
                id = UUID("uuid@random.de"),
                day = Time.Day(unix = 0),
                message = null,
                teacher = null,
                subject = null,
                clazz = null,
                lesson = null,
                room = null,
                origTeacher = null,
                origSubject = null,
                isEliminated = false
            ),
            Json.parse(StandInSerializer, standInJson),
            "parse json"
        )
        assertEquals(
            standInJson,
            Json.stringify(StandInSerializer, StandIn.Impl(
                id = UUID("uuid@random.de"),
                day = Time.Day(unix = 0),
                message = null,
                teacher = null,
                subject = null,
                clazz = null,
                lesson = null,
                room = null,
                origTeacher = null,
                origSubject = null,
                isEliminated = false
            )),
            "stringify object to json"
        )
    }
}
