package com.molikuner.vpapp.data.util

import com.molikuner.vpapp.data.util.APIResult.Error.AbstractAPIError.APIError
import com.molikuner.vpapp.data.util.APIResult.Error.AbstractAPIError.NothingNew
import io.ktor.client.call.receive
import io.ktor.client.response.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    val asSuccess: Result.Success<T>?
        get() = this as? Success<T>
}

@ExperimentalContracts
fun <T : Any> Result<T>.isErrored(): Boolean {
    contract {
        returns(false) implies (this@isErrored is Result.Success)
        returns(true) implies (this@isErrored is Result.Error)
    }
    return this is Result.Success
}

sealed class APIResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : APIResult<T>()
    sealed class Error : APIResult<Nothing>() {
        @Serializable
        data class BackendError(val error: String) : Error()

        object Moved : Error()
        object ProxyError : Error()
        object ServerError : Error()
        object TooLarge : Error()
        object Version2Low : Error()
        /**
         * invalid response from api
         * */
        sealed class AbstractAPIError(open val responseCode: Int) : Error() {
            object NothingNew : AbstractAPIError(304)
            data class APIError(override val responseCode: Int) : AbstractAPIError(responseCode)
        }

        data class LocalError(val message: String, val exception: Exception) : Error()
    }

    companion object {
        suspend inline fun <reified T : Any> ofHttpResponse(
            response: HttpResponse,
            allowNothingNew: Boolean = false
        ): APIResult<T> {
            return when (val code = response.status) {
                HttpStatusCode.OK -> Success(response.receive())
                HttpStatusCode.NothingNew -> if (allowNothingNew) NothingNew else APIError(code.value)
                HttpStatusCode.MovedPermanently -> Error.Moved
                HttpStatusCode.PayloadTooLarge -> Error.TooLarge
                HttpStatusCode.BadRequest -> response.receive<Error.BackendError>()
                HttpStatusCode.Version2Low -> Error.Version2Low
                HttpStatusCode.InternalServerError -> Error.ServerError
                HttpStatusCode.BadGateway -> Error.ProxyError
                else -> APIError(code.value)
            }
        }
    }
}

val <T> T.exhaustive: T
    get() = this

suspend fun <T : Any> safeApiCall(
    errorMessage: String,
    leftTries: Byte = 2,
    call: suspend () -> APIResult<T>
): APIResult<T> {
    return try {
        call()
    } catch (e: Exception) {
        if (leftTries > 0 && e !is FatalException) return safeApiCall(
            errorMessage,
            leftTries.dec(),
            call
        )
        APIResult.Error.LocalError(errorMessage, e)
    }
}

class FatalException(
    result: APIResult.Error,
    message: String? = if (result is APIResult.Error.BackendError) result.error else null,
    cause: Throwable? = null
) : IllegalStateException(message, cause)
