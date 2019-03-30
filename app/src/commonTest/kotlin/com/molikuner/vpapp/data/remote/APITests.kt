package com.molikuner.vpapp.data.remote

import com.molikuner.vpapp.data.remote.types.DataStatus
import com.molikuner.vpapp.data.remote.types.StandInResponse
import com.molikuner.vpapp.data.util.APIResult
import com.molikuner.vpapp.data.util.NothingNew
import com.molikuner.vpapp.invoke
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.types.Version
import com.molikuner.vpapp.util.runBlocking
import com.molikuner.vpapp.util.simpleTry
import com.molikuner.vpapp.util.unit
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockHttpResponse
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.io.ByteReadChannel
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class APITests {
    private val api = with(MockEngine {
        if (headers["User-Agent"]?.isNotEmpty() != true) error("useragent is empty")
        if (headers["platform"]?.let { it == "android" || it == "ios" } != true) {
            error("unknown or empty platform: '${headers["platform"]}'")
        }
        simpleTry("malformed version string: '${headers["version"]}'") {
            Version(headers["version"] ?: error("version is missing"))
        }
        val content: TextContent = content.let {
            if (it !is TextContent || it.contentType != ContentType.Application.Json) {
                error("'Content-Type' is '${it.contentType} instead of 'application/json''")
            }
            return@let it
        }
        when (url.toString()) {
            "https://keeweb.molikuner.com/api/v1.0.0/stand-in.json" -> {
                val status = Json.parse(DataStatus.serializer(), content.text)
                if (status.has.size != 1) error("this test is unfinished; please fix it")
                when (status.has[0]) {
                    NOTHING_NEW -> {
                        MockHttpResponse(
                            call,
                            HttpStatusCode.NothingNew,
                            content = ByteReadChannel("""{"requestTime":"DT0", "add": [], "remove": []}"""),
                            headers = headersOf("Content-Type", "application/json")
                        )
                    }
                    NOTHING -> {
                        MockHttpResponse(
                            call,
                            HttpStatusCode.OK,
                            content = ByteReadChannel("""{"requestTime":"DT0", "add": [], "remove": []}"""),
                            headers = headersOf("Content-Type", "application/json")
                        )
                    }
                    else -> error("unknown stand-in api call: ${status.has[0].id}")
                }
            }
            else -> error("error; unknown api call: $url")
        }
    })

    companion object {
        val NOTHING_NEW = UUID("nothing@new.test")
        val NOTHING = UUID("nothin@test.de")
    }

    @Test
    fun testStandInAPI() = runBlocking {
        assertEquals(
            api.standIn(DataStatus(NOTHING_NEW)),
            APIResult.Error.AbstractAPIError.NothingNew,
            "Returned nothingNew"
        )
        assertEquals(
            api.standIn(DataStatus(NOTHING)),
            APIResult.Success(
                StandInResponse(
                    requestTime = Time.Timestamp(0L),
                    addStandIn = listOf(),
                    addMOTD = listOf(),
                    remove = listOf()
                )
            ),
            "Returned nothing"
        )
    }.unit
}

fun with(engine: MockEngine): API {
    return object : API {
        override val client: HttpClient = HttpClient(engine, API.initClient)
    }
}
