[data](../index.md) / [com.molikuner.nigb.data.remote.common](index.md) / [safeApiCall](./safe-api-call.md)

# safeApiCall

`suspend fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> safeApiCall(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, leftTries: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)` = 2, cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null, call: suspend () -> Result<`[`T`](safe-api-call.md#T)`>): Result<`[`T`](safe-api-call.md#T)`>`

Function to make simple safe [calls](safe-api-call.md#com.molikuner.nigb.data.remote.common$safeApiCall(kotlin.String, kotlin.Byte, kotlin.Throwable, kotlin.SuspendFunction0((com.molikuner.util.data.Result((com.molikuner.nigb.data.remote.common.safeApiCall.T)))))/call) (suspend)

Simple function to make safe [calls](safe-api-call.md#com.molikuner.nigb.data.remote.common$safeApiCall(kotlin.String, kotlin.Byte, kotlin.Throwable, kotlin.SuspendFunction0((com.molikuner.util.data.Result((com.molikuner.nigb.data.remote.common.safeApiCall.T)))))/call) over (unstable) net
Has [2](safe-api-call.md#com.molikuner.nigb.data.remote.common$safeApiCall(kotlin.String, kotlin.Byte, kotlin.Throwable, kotlin.SuspendFunction0((com.molikuner.util.data.Result((com.molikuner.nigb.data.remote.common.safeApiCall.T)))))/leftTries) retries by default, but can be "disabled" by set
[leftTries](safe-api-call.md#com.molikuner.nigb.data.remote.common$safeApiCall(kotlin.String, kotlin.Byte, kotlin.Throwable, kotlin.SuspendFunction0((com.molikuner.util.data.Result((com.molikuner.nigb.data.remote.common.safeApiCall.T)))))/leftTries) to 0. This function uses recursion to to the retries

### Parameters

`errorMessage` - is the message if an error occurs

`leftTries` - is the number of tries to do on error
default is 2

`cause` - is an internal used Throwable to return all errors,
but could be used to give a reason why a [calls](safe-api-call.md#com.molikuner.nigb.data.remote.common$safeApiCall(kotlin.String, kotlin.Byte, kotlin.Throwable, kotlin.SuspendFunction0((com.molikuner.util.data.Result((com.molikuner.nigb.data.remote.common.safeApiCall.T)))))/call) was made
default is null

`call` - is a suspend lambda to be called save