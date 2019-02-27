package com.molikuner.vpapp.data.remote

import com.molikuner.vpapp.data.remote.types.EndpointRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.HttpClientCall
import io.ktor.client.call.call
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.userAgent

object API {
    private val client = HttpClient {
        install(JsonFeature)
    }

    suspend fun request(r: EndpointRequest): HttpClientCall {
        return client.call {
            method = r.method
            url(r.url)
            headers {
                r.header.forEach {
                    this[it.key] = it.value
                }
                this["platform"] = r.platform
                this["version"] = r.version.toString()
            }
            userAgent(r.userAgent.agent)
            body = r.body
        }
    }
}