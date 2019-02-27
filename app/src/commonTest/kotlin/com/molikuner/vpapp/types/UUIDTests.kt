package com.molikuner.vpapp

import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class UUIDTests {
    private val uuidJson = "uuid@random.de"

    @Test
    fun testUUIDSerialization() {
        assertEquals(
            UUID("uuid@random.de"),
            Json.parse(UUID.serializer(), uuidJson),
            "serialize uuid"
        )
    }
}
