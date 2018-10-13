[data](../../index.md) / [com.molikuner.nigb.data.remote.common](../index.md) / [APIService](index.md) / [request](./request.md)

# request

`suspend fun request(endpoint: `[`APIEndpoints`](../-a-p-i-endpoints/index.md)`, requestBody: RequestBody? = null, additionalRequestHeader: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null): Response`

Function to request the [backend](https://nigb.app)

This function will simply request the given [endpoint](request.md#com.molikuner.nigb.data.remote.common.APIService$request(com.molikuner.nigb.data.remote.common.APIEndpoints, com.molikuner.http.RequestBody, kotlin.collections.Map((kotlin.String, )))/endpoint)
with the given [requestBody](request.md#com.molikuner.nigb.data.remote.common.APIService$request(com.molikuner.nigb.data.remote.common.APIEndpoints, com.molikuner.http.RequestBody, kotlin.collections.Map((kotlin.String, )))/requestBody) and [headers](request.md#com.molikuner.nigb.data.remote.common.APIService$request(com.molikuner.nigb.data.remote.common.APIEndpoints, com.molikuner.http.RequestBody, kotlin.collections.Map((kotlin.String, )))/additionalRequestHeader)
The request will be made using the [simpleHttp](https//github.com/molikuner/simpleHttp)
library
It is a suspend function to be safer it is called from the right thread

### Parameters

`endpoint` - is the endpoint of the [backend](https://nigb.app) to be requested

`requestBody` - is the body to be send with the request
by default it is null

`additionalRequestHeader` - is a map of additional headers
for the request

**Return**
the [response](#) of the request

