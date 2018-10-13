[data](../index.md) / [com.molikuner.nigb.data.remote.common](./index.md)

## Package com.molikuner.nigb.data.remote.common

### Types

| [APIEndpoints](-a-p-i-endpoints/index.md) | `enum class APIEndpoints`<br>Enum of APIEndpoints in the [backend](https://nigb.app) |
| [APIService](-a-p-i-service/index.md) | `object APIService`<br>Singleton object to do requests to the [backend](https://nigb.app) |

### Properties

| [exhaustive](exhaustive.md) | `val <T> `[`T`](exhaustive.md#T)`.exhaustive: `[`T`](exhaustive.md#T)<br>Make a when(x) call exhaustive |

### Functions

| [safeApiCall](safe-api-call.md) | `suspend fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> safeApiCall(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, leftTries: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)` = 2, cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null, call: suspend () -> Result<`[`T`](safe-api-call.md#T)`>): Result<`[`T`](safe-api-call.md#T)`>`<br>Function to make simple safe [calls](safe-api-call.md#com.molikuner.nigb.data.remote.common$safeApiCall(kotlin.String, kotlin.Byte, kotlin.Throwable, kotlin.SuspendFunction0((com.molikuner.util.data.Result((com.molikuner.nigb.data.remote.common.safeApiCall.T)))))/call) (suspend) |

