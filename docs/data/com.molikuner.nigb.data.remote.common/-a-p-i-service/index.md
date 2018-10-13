[data](../../index.md) / [com.molikuner.nigb.data.remote.common](../index.md) / [APIService](./index.md)

# APIService

`object APIService`

Singleton object to do requests to the [backend](https://nigb.app)

This singleton object is the main point for the app to make
request to the [backend](https://nigb.app)

### Functions

| [request](request.md) | `suspend fun request(endpoint: `[`APIEndpoints`](../-a-p-i-endpoints/index.md)`, requestBody: RequestBody? = null, additionalRequestHeader: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null): Response`<br>Function to request the [backend](https://nigb.app) |

