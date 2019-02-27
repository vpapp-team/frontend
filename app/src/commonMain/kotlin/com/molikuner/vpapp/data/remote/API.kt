package com.molikuner.vpapp.data.remote

import com.molikuner.vpapp.data.remote.types.DataStatus
import com.molikuner.vpapp.data.remote.types.StandInResponse
import com.molikuner.vpapp.data.remote.types.UpdateResponse
import com.molikuner.vpapp.data.util.APIResult
import com.molikuner.vpapp.platform.Platform
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.call
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.headers
import io.ktor.client.response.HttpResponse
import io.ktor.client.utils.EmptyContent
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.userAgent

interface API {
    val client: HttpClient

    suspend fun update(): APIResult<UpdateResponse> {
        return APIResult.ofHttpResponse(request("updates", reqMethod = HttpMethod.Get))
    }

    suspend fun standIn(status: DataStatus): APIResult<StandInResponse> {
        return APIResult.ofHttpResponse(request("stand-in", status), allowNothingNew = true)
    }

    private suspend fun request(endpoint: String, reqBody: Any = EmptyContent, reqMethod: HttpMethod = HttpMethod.Post, vararg header: Pair<String, String>): HttpResponse {
        return this@API.client.call {
            method = reqMethod
            url {
                host = "api.nigb.app"
                encodedPath = "/api/v1.0.0/$endpoint"
                protocol = URLProtocol.HTTPS
            }
            headers {
                header.forEach {
                    this[it.first] = it.second
                }
                this["platform"] = Platform.PLATFORM
                this["version"] = Platform.VERSION.toString()
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
