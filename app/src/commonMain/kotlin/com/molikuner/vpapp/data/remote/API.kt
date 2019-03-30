package com.molikuner.vpapp.data.remote

import com.molikuner.vpapp.data.remote.types.DataStatus
import com.molikuner.vpapp.data.remote.types.DefaultResponse
import com.molikuner.vpapp.data.remote.types.StandInResponse
import com.molikuner.vpapp.data.remote.types.UpdateResponse
import com.molikuner.vpapp.data.util.APIResult
import com.molikuner.vpapp.data.util.serialization.serializer
import com.molikuner.vpapp.platform.Platform
import com.molikuner.vpapp.types.Time
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.call
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.headers
import io.ktor.client.response.HttpResponse
import io.ktor.client.utils.EmptyContent
import io.ktor.http.ContentType
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.userAgent

interface API {
    val client: HttpClient

    suspend fun update(): APIResult<UpdateResponse> {
        return APIResult.ofHttpResponse(request("updates", reqMethod = HttpMethod.Get, requestTime = null))
    }

    suspend fun calendar(status: DataStatus): APIResult<DefaultResponse.CalendarResponse> {
        return APIResult.ofHttpResponse(request("calendar", status), allowNothingNew = true)
    }

    suspend fun menu(status: DataStatus): APIResult<DefaultResponse.MenuResponse> {
        return APIResult.ofHttpResponse(request("menu", status), allowNothingNew = true)
    }

    suspend fun standIn(status: DataStatus): APIResult<StandInResponse> {
        return APIResult.ofHttpResponse(request("stand-in", status), allowNothingNew = true)
    }

    suspend fun teachers(status: DataStatus): APIResult<DefaultResponse.TeacherResponse> {
        return APIResult.ofHttpResponse(request("teachers", status), allowNothingNew = true)
    }

    suspend fun timetables(
        status: DataStatus,
        clazzes: Boolean = true,
        rooms: Boolean = true,
        teachers: Boolean = true
    ): APIResult<DefaultResponse.TimetableResponse> {
        return APIResult.ofHttpResponse(request("timetables", status) {
            this["teachers"] = "$teachers"
            this["rooms"] = "$rooms"
            this["clazzes"] = "$clazzes"
        }, allowNothingNew = true)
    }

    private suspend inline fun request(
        endpoint: String,
        reqBody: Any = EmptyContent,
        reqMethod: HttpMethod = HttpMethod.Post,
        requestTime: Time? = Time.now(),
        crossinline customHeader: HeadersBuilder.() -> Unit = {}
    ): HttpResponse {
        return this@API.client.call {
            method = reqMethod
            url {
                host = "keeweb.molikuner.com"
                encodedPath = "/api/v1.0.0/$endpoint.json"
                protocol = URLProtocol.HTTPS
            }
            headers {
                requestTime?.also {
                    this["requestTime"] = it.toString()
                }
                this["platform"] = Platform.PLATFORM
                this["version"] = Platform.VERSION.toString()
                customHeader()
            }
            userAgent("completely-random-string")
            body = reqBody
            contentType(ContentType.Application.Json)
        }.response
    }

    companion object : API {
        internal val initClient: HttpClientConfig<*>.() -> Unit = {
            install(JsonFeature) {
                serializer = KotlinxSerializer().apply {
                    setMapper(StandInResponse::class, StandInResponse.serializer())
                }
            }
            expectSuccess = false
        }

        override val client: HttpClient by lazy { HttpClient(initClient) }
    }
}
