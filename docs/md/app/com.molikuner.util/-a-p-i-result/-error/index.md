[app](../../../index.md) / [com.molikuner.util](../../index.md) / [APIResult](../index.md) / [Error](./index.md)

# Error

`sealed class Error : `[`APIResult`](../index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>`

### Types

| Name | Summary |
|---|---|
| [APIError](-a-p-i-error/index.md) | `data class APIError : `[`Error`](./index.md)<br>invalid response from api |
| [BackendError](-backend-error/index.md) | `data class BackendError : `[`Error`](./index.md) |
| [LocalError](-local-error/index.md) | `data class LocalError : `[`Error`](./index.md) |
| [Moved](-moved.md) | `object Moved : `[`Error`](./index.md) |
| [ProxyError](-proxy-error.md) | `object ProxyError : `[`Error`](./index.md) |
| [ServerError](-server-error.md) | `object ServerError : `[`Error`](./index.md) |
| [ToLarge](-to-large.md) | `object ToLarge : `[`Error`](./index.md) |
| [VersionToLow](-version-to-low.md) | `object VersionToLow : `[`Error`](./index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [APIError](-a-p-i-error/index.md) | `data class APIError : `[`Error`](./index.md)<br>invalid response from api |
| [BackendError](-backend-error/index.md) | `data class BackendError : `[`Error`](./index.md) |
| [LocalError](-local-error/index.md) | `data class LocalError : `[`Error`](./index.md) |
| [Moved](-moved.md) | `object Moved : `[`Error`](./index.md) |
| [ProxyError](-proxy-error.md) | `object ProxyError : `[`Error`](./index.md) |
| [ServerError](-server-error.md) | `object ServerError : `[`Error`](./index.md) |
| [ToLarge](-to-large.md) | `object ToLarge : `[`Error`](./index.md) |
| [VersionToLow](-version-to-low.md) | `object VersionToLow : `[`Error`](./index.md) |
