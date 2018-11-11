[app](../../index.md) / [com.molikuner.vpapp.types.responses](../index.md) / [UpdatesResponse](./index.md)

# UpdatesResponse

`data class UpdatesResponse : `[`Response`](../-response/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UpdatesResponse(requestTime: `[`Time`](../../com.molikuner.types/-time/index.md)`, lastUpdates: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`LastUpdate`](../../com.molikuner.vpapp.types.data/-last-update/index.md)`>, recommendedVersion: `[`Version`](../../com.molikuner.types/-version/index.md)`, minVersion: `[`Version`](../../com.molikuner.types/-version/index.md)`, recommendedDays: `[`Range`](../../com.molikuner.types/-range/index.md)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null)` |

### Properties

| Name | Summary |
|---|---|
| [lastUpdates](last-updates.md) | `val lastUpdates: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`LastUpdate`](../../com.molikuner.vpapp.types.data/-last-update/index.md)`>` |
| [message](message.md) | `val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [minVersion](min-version.md) | `val minVersion: `[`Version`](../../com.molikuner.types/-version/index.md) |
| [recommendedDays](recommended-days.md) | `val recommendedDays: `[`Range`](../../com.molikuner.types/-range/index.md) |
| [recommendedVersion](recommended-version.md) | `val recommendedVersion: `[`Version`](../../com.molikuner.types/-version/index.md) |
| [requestTime](request-time.md) | `val requestTime: `[`Time`](../../com.molikuner.types/-time/index.md) |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
