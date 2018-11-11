[app](../../index.md) / [com.molikuner.vpapp.types.responses](../index.md) / [TimetablesResponse](./index.md)

# TimetablesResponse

`data class TimetablesResponse : `[`Response`](../-response/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TimetablesResponse(requestTime: `[`Time`](../../com.molikuner.types/-time/index.md)`, add: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Timetable`](../../com.molikuner.vpapp.types.data/-timetable/index.md)`>, remove: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`>, hours: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`LessonRange`](../../com.molikuner.vpapp.types.data/-lesson-range/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [add](add.md) | `val add: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Timetable`](../../com.molikuner.vpapp.types.data/-timetable/index.md)`>` |
| [hours](hours.md) | `val hours: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`LessonRange`](../../com.molikuner.vpapp.types.data/-lesson-range/index.md)`>` |
| [remove](remove.md) | `val remove: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`>` |
| [requestTime](request-time.md) | `val requestTime: `[`Time`](../../com.molikuner.types/-time/index.md) |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
