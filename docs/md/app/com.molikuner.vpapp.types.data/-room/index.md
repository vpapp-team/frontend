[app](../../index.md) / [com.molikuner.vpapp.types.data](../index.md) / [Room](./index.md)

# Room

`data class Room`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Room(id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, x_cord: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, y_cord: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, height: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, width: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, timetable: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Timetable`](../-timetable/index.md)`>? = null)` |

### Properties

| Name | Summary |
|---|---|
| [height](height.md) | `val height: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [id](id.md) | `val id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md) |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [timetable](timetable.md) | `val timetable: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Timetable`](../-timetable/index.md)`>?` |
| [uri](uri.md) | `val uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [width](width.md) | `val width: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [x_cord](x_cord.md) | `val x_cord: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [y_cord](y_cord.md) | `val y_cord: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Room`](./index.md) |
