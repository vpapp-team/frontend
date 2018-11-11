[app](../index.md) / [com.molikuner.util](index.md) / [safeApiCall](./safe-api-call.md)

# safeApiCall

`suspend fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> safeApiCall(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, leftTries: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)` = 2, call: suspend () -> `[`APIResult`](-a-p-i-result/index.md)`<`[`T`](safe-api-call.md#T)`>): `[`APIResult`](-a-p-i-result/index.md)`<`[`T`](safe-api-call.md#T)`>`

Function to make simple safe [calls](safe-api-call.md#com.molikuner.util$safeApiCall(kotlin.String, kotlin.Byte, kotlin.SuspendFunction0((com.molikuner.util.APIResult((com.molikuner.util.safeApiCall.T)))))/call) (suspend)

Simple function to make safe [calls](safe-api-call.md#com.molikuner.util$safeApiCall(kotlin.String, kotlin.Byte, kotlin.SuspendFunction0((com.molikuner.util.APIResult((com.molikuner.util.safeApiCall.T)))))/call) over (unstable) net
Has [2](safe-api-call.md#com.molikuner.util$safeApiCall(kotlin.String, kotlin.Byte, kotlin.SuspendFunction0((com.molikuner.util.APIResult((com.molikuner.util.safeApiCall.T)))))/leftTries) retries by default, but can be "disabled" by set
[leftTries](safe-api-call.md#com.molikuner.util$safeApiCall(kotlin.String, kotlin.Byte, kotlin.SuspendFunction0((com.molikuner.util.APIResult((com.molikuner.util.safeApiCall.T)))))/leftTries) to 0. This function uses recursion to to the retries

### Parameters

`errorMessage` - is the message if an error occurs

`leftTries` - is the number of tries to do on error
default is 2

`call` - is a suspend lambda to be called save