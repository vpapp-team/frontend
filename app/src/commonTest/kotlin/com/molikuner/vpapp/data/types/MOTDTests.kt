package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.MOTD
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class MOTDTests {
    private val motdJson = """["uuid@random.de",1,0,"D0","Test Message"]"""

    @Test
    fun testMOTDSerialization() {
        assertEquals(
            MOTD.Impl(
                id = UUID("uuid@random.de"),
                type = MOTDTypes.OTHER,
                day = Time.Day(unix = 0),
                message = "Test Message"
            ),
            Json.parse(MOTDSerializer, motdJson),
            "parse MOTD from json"
        )
        assertEquals(
            motdJson,
            Json.stringify(MOTDSerializer, MOTD.Impl(
                id = UUID("uuid@random.de"),
                type = MOTDTypes.OTHER,
                day = Time.Day(unix = 0),
                message = "Test Message"
            )),
            "stringify MOTD to json"
        )
    }
}
