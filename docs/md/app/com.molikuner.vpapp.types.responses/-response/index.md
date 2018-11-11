[app](../../index.md) / [com.molikuner.vpapp.types.responses](../index.md) / [Response](./index.md)

# Response

`abstract class Response`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Response(requestTime: `[`Time`](../../com.molikuner.types/-time/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [requestTime](request-time.md) | `open val requestTime: `[`Time`](../../com.molikuner.types/-time/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [SimpleResponse](../-simple-response/index.md) | `data class SimpleResponse<T> : `[`Response`](./index.md) |
| [TimetablesResponse](../-timetables-response/index.md) | `data class TimetablesResponse : `[`Response`](./index.md) |
| [UpdatesResponse](../-updates-response/index.md) | `data class UpdatesResponse : `[`Response`](./index.md) |
