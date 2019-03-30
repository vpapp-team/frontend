package com.molikuner.vpapp.data.util

import com.molikuner.vpapp.data.util.serialization.use
import com.molikuner.vpapp.data.util.serialization.SerialArrayClassDescImpl
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonParsingException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SerialArrayClassDescImplTests {

    @Test
    fun testTooShortArray() {
        assertFailsWith<JsonParsingException> {
            Json.parse(object : DummySerializer {
                override fun deserialize(decoder: Decoder): DummyData {
                    return decoder.use(descriptor) {
                        DummyData(
                            a = decodeBooleanElement(0),
                            b = decodeNullableBooleanElement(2)
                        )
                    }
                }
            }, "[true,null]")
        }
    }

    @Test
    fun testTooLongArray() {
        assertFailsWith<JsonParsingException> {
            Json.parse(object : DummySerializer {
                override fun deserialize(decoder: Decoder): DummyData {
                    return decoder.use(descriptor) {
                        DummyData(
                            a = decodeBooleanElement(0),
                            b = decodeNullableBooleanElement(2)
                        )
                    }
                }
            }, "[true,null,null,null]")
        }
        assertFailsWith<JsonParsingException> {
            Json.parse(object : DummySerializer {
                override fun deserialize(decoder: Decoder): DummyData {
                    return decoder.use(descriptor, 5) {
                        DummyData(
                            a = decodeBooleanElement(0),
                            b = decodeNullableBooleanElement(2)
                        )
                    }
                }
            }, "[true,null,null,null,null,null,null]")
        }
    }

    @Test
    fun testExpectedTooLongArray() {
        assertEquals(
            DummyData(true, null),
            Json.parse(object : DummySerializer {
                override fun deserialize(decoder: Decoder): DummyData {
                    return decoder.use(descriptor, 4) {
                        DummyData(
                            a = decodeBooleanElement(0),
                            b = decodeNullableBooleanElement(2)
                        )
                    }
                }
            }, "[true,null,null,null]")
        )
    }
}

internal data class DummyData(val a: Boolean, val b: Boolean?)

internal interface DummySerializer : KSerializer<DummyData> {
    override val descriptor: SerialDescriptor
        get() = object : SerialArrayClassDescImpl("DummyData") {
            init {
                addElement(DummyData::a, 0)
                addElement(DummyData::b, 2)
            }
        }

    override fun patch(decoder: Decoder, old: DummyData): DummyData {
        return this.deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, obj: DummyData) {
        return encoder.use(descriptor) {
            encodeBooleanElement(0, obj.a)
            encodeNullableBooleanElement(2, obj.b)
        }
    }
}
