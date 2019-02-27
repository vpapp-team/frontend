package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.types.Range
import com.molikuner.vpapp.types.Time
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json

sealed class EndpointRequest(
    endpointName: String,
    val method: HttpMethod,
    val body: String,
    val header: Map<String, String>
) {
    val url: String = "https://api.nigb.app/v1.0.0/$endpointName"

    abstract class CommonRequest(
        endpointName: String,
        requestTime: Time,
        status: DataStatus,
        method: HttpMethod = HttpMethod.Post,
        body: String = Json.stringify(DataStatus.serializer(), status),
        vararg header: Pair<String, String>
    ) : EndpointRequest(
        endpointName = endpointName,
        method = method,
        body = body,
        header = mapOf(
            "requestTime" to requestTime.toString(),
            *header
        )
    )

    data class StandIn(
        val requestTime: Time,
        val range: Range,
        val status: DataStatus
    ) : CommonRequest(
        endpointName = "stand-ins",
        requestTime = requestTime,
        status = status,
        header = *arrayOf("range" to range.toString())
    )
}

sealed class ResponseCode(val code: Int) {
    companion object {
        fun find(code: Int, allowCommon: Boolean = true) = when (code) {
            200 -> DefaultResponseCodes.Okay
            301 -> DefaultResponseCodes.Moved
            304 -> if (allowCommon) CommonResponseCodes.NothingNew else DefaultResponseCodes.UnknownResponseCode(304)
            413 -> DefaultResponseCodes.TooLarge
            400 -> DefaultResponseCodes.Error
            424 -> DefaultResponseCodes.VersionToLow
            500 -> DefaultResponseCodes.InternalServerError
            502 -> DefaultResponseCodes.ProxyError
            else -> DefaultResponseCodes.UnknownResponseCode(code)
        }
    }
}
sealed class DefaultResponseCodes(code: Int) : ResponseCode(code) {
    object Okay : DefaultResponseCodes(200)
    object Moved : DefaultResponseCodes(301)
    object TooLarge : DefaultResponseCodes(413)
    object Error : DefaultResponseCodes(400)
    object VersionToLow : DefaultResponseCodes(424)
    object InternalServerError : DefaultResponseCodes(500)
    object ProxyError : DefaultResponseCodes(502)
    class UnknownResponseCode(code: Int) : DefaultResponseCodes(code)
}
sealed class CommonResponseCodes(code: Int) : DefaultResponseCodes(code) {
    object NothingNew : CommonResponseCodes(304)
}
