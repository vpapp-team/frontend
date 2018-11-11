[app](../../index.md) / [com.molikuner.types](../index.md) / [Time](./index.md)

# Time

`data class Time`

### Types

| Name | Summary |
|---|---|
| [ANY](-a-n-y/index.md) | `object ANY` |
| [WEEK](-w-e-e-k/index.md) | `object WEEK` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Time(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, representsDay: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [day](day.md) | `val day: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [hour](hour.md) | `val hour: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isWeekday](is-weekday.md) | `val isWeekday: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [min](min.md) | `val min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [sec](sec.md) | `val sec: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [time](time.md) | `val time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [weekday](weekday.md) | `val weekday: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(time: `[`Time`](./index.md)`): `[`Time`](./index.md) |
| [addDay](add-day.md) | `fun addDay(onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, days: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1): `[`Time`](./index.md) |
| [compareTo](compare-to.md) | `operator fun compareTo(time: `[`Time`](./index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [dec](dec.md) | `operator fun dec(): `[`Time`](./index.md) |
| [inc](inc.md) | `operator fun inc(): `[`Time`](./index.md) |
| [isAtDay](is-at-day.md) | `infix fun isAtDay(check: `[`Time`](./index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isBetween](is-between.md) | `fun isBetween(from: `[`Time`](./index.md)`, to: `[`Time`](./index.md)`, includeDay: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, rangeExtension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = if (from.representsDay || this.representsDay) 1 else 0): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [matches](matches.md) | `fun matches(day: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [minus](minus.md) | `operator fun minus(days: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Time`](./index.md)<br>`operator fun minus(time: `[`Time`](./index.md)`): `[`Time`](./index.md) |
| [plus](plus.md) | `operator fun plus(days: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Time`](./index.md)<br>`operator fun plus(time: `[`Time`](./index.md)`): `[`Time`](./index.md) |
| [rangeTo](range-to.md) | `operator fun rangeTo(time: `[`Time`](./index.md)`): `[`Range`](../-range/index.md) |
| [rem](rem.md) | `fun rem(time: `[`Time`](./index.md)`): `[`Time`](./index.md) |
| [remDay](rem-day.md) | `fun remDay(onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, days: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1): `[`Time`](./index.md) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DAY](-d-a-y.md) | `const val DAY: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [FRIDAY](-f-r-i-d-a-y.md) | `const val FRIDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [HOUR](-h-o-u-r.md) | `const val HOUR: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [MONDAY](-m-o-n-d-a-y.md) | `const val MONDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SATURDAY](-s-a-t-u-r-d-a-y.md) | `const val SATURDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SUNDAY](-s-u-n-d-a-y.md) | `const val SUNDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [THURSDAY](-t-h-u-r-s-d-a-y.md) | `const val THURSDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [TODAY](-t-o-d-a-y.md) | `const val TODAY: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TOMORROW](-t-o-m-o-r-r-o-w.md) | `const val TOMORROW: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TUESDAY](-t-u-e-s-d-a-y.md) | `const val TUESDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WEDNESDAY](-w-e-d-n-e-s-d-a-y.md) | `const val WEDNESDAY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [YESTERDAY](-y-e-s-t-e-r-d-a-y.md) | `const val YESTERDAY: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [now](now.md) | `val now: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getHour](get-hour.md) | `fun getHour(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = now): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [of](of.md) | `fun of(time: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Time`](./index.md)<br>`fun of(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = now, representsDay: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Time`](./index.md)<br>`fun of(day: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Time`](./index.md)<br>`fun of(day: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Time`](./index.md) |
