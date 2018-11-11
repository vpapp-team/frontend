[app](../../index.md) / [com.molikuner.types](../index.md) / [Range](./index.md)

# Range

`data class Range`

### Properties

| Name | Summary |
|---|---|
| [isInfinite](is-infinite.md) | `val isInfinite: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | `operator fun contains(testDate: `[`Time`](../-time/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [calendar](calendar.md) | `val calendar: `[`Range`](./index.md) |
| [menu](menu.md) | `val menu: `[`Range`](./index.md) |
| [standIns](stand-ins.md) | `val standIns: `[`Range`](./index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [around](around.md) | `fun around(around: `[`Time`](../-time/index.md)`): `[`RangeAroundBuilder`](../-range-around-builder/index.md) |
| [from](from.md) | `fun from(start: `[`Time`](../-time/index.md)`): `[`RangeBuilder`](../-range-builder/index.md) |
| [of](of.md) | `fun of(range: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Range`](./index.md) |
| [since](since.md) | `fun since(start: `[`Time`](../-time/index.md)`): `[`Range`](./index.md) |
| [until](until.md) | `fun until(end: `[`Time`](../-time/index.md)`): `[`Range`](./index.md) |
