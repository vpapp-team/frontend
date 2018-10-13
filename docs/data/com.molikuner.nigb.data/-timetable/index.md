[data](../../index.md) / [com.molikuner.nigb.data](../index.md) / [Timetable](./index.md)

# Timetable

`data class Timetable`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Timetable(id: UUID, type: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, master: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, activation: Time, lesson: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Lesson`](../-lesson/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [activation](activation.md) | `val activation: Time` |
| [id](id.md) | `val id: UUID` |
| [lesson](lesson.md) | `val lesson: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Lesson`](../-lesson/index.md)`>` |
| [master](master.md) | `val master: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `val type: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`JSONArray`](https://developer.android.com/reference/org/json/JSONArray.html)`): `[`Timetable`](./index.md) |
