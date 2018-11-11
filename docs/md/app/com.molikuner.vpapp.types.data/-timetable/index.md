[app](../../index.md) / [com.molikuner.vpapp.types.data](../index.md) / [Timetable](./index.md)

# Timetable

`data class Timetable`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Timetable(id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`, type: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, master: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, activation: `[`Time`](../../com.molikuner.types/-time/index.md)`, lesson: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Lesson`](../-lesson/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [activation](activation.md) | `val activation: `[`Time`](../../com.molikuner.types/-time/index.md) |
| [id](id.md) | `val id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md) |
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
| [of](of.md) | `fun of(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Timetable`](./index.md) |
