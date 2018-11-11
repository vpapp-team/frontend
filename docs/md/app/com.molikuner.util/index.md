[app](../index.md) / [com.molikuner.util](./index.md)

## Package com.molikuner.util

### Types

| Name | Summary |
|---|---|
| [APIResult](-a-p-i-result/index.md) | `sealed class APIResult<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |
| [ContentViewBindingDelegate](-content-view-binding-delegate/index.md)<br>(android) | `class ContentViewBindingDelegate<in R, out T>` |
| [Event](-event/index.md)<br>(android) | `open class Event<out T>` |
| [EventObserver](-event-observer/index.md)<br>(android) | `class EventObserver<T>` |
| [Platform](-platform/index.md)<br>(android, ios) | `expect object Platform` |
| [Result](-result/index.md) | `sealed class Result<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |

### Properties

| Name | Summary |
|---|---|
| [exhaustive](exhaustive.md) | `val <T> `[`T`](exhaustive.md#T)`.exhaustive: `[`T`](exhaustive.md#T)<br>Make a when(x) call exhaustive |

### Functions

| Name | Summary |
|---|---|
| [contentView](content-view.md)<br>(android) | `fun <R, T> contentView(layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ContentViewBindingDelegate`](-content-view-binding-delegate/index.md)`<`[`R`](content-view.md#R)`, `[`T`](content-view.md#T)`>` |
| [isErrored](is-errored.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Result`](-result/index.md)`<`[`T`](is-errored.md#T)`>.isErrored(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [safeApiCall](safe-api-call.md) | `suspend fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> safeApiCall(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, leftTries: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)` = 2, call: suspend () -> `[`APIResult`](-a-p-i-result/index.md)`<`[`T`](safe-api-call.md#T)`>): `[`APIResult`](-a-p-i-result/index.md)`<`[`T`](safe-api-call.md#T)`>`<br>Function to make simple safe [calls](safe-api-call.md#com.molikuner.util$safeApiCall(kotlin.String, kotlin.Byte, kotlin.SuspendFunction0((com.molikuner.util.APIResult((com.molikuner.util.safeApiCall.T)))))/call) (suspend) |
