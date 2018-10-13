[data](../../index.md) / [com.molikuner.nigb.data.types](../index.md) / [CalendarEvent](./index.md)

# CalendarEvent

`data class CalendarEvent`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CalendarEvent(id: UUID, description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, end: Time, humanRecurringRule: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, start: Time, summary: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [description](description.md) | `val description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [end](end.md) | `val end: Time` |
| [humanRecurringRule](human-recurring-rule.md) | `val humanRecurringRule: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [id](id.md) | `val id: UUID` |
| [location](location.md) | `val location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [start](start.md) | `val start: Time` |
| [summary](summary.md) | `val summary: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`JSONArray`](https://developer.android.com/reference/org/json/JSONArray.html)`): `[`CalendarEvent`](./index.md) |
