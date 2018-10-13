[types](../../index.md) / [com.molikuner.nigb.types](../index.md) / [Time](./index.md)

# Time

`class Time : `[`Date`](https://developer.android.com/reference/java/util/Date.html)`, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)

### Properties

| Name | Summary |
|---|---|
| [hour](hour.md) | `val hour: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isWeekday](is-weekday.md) | `val isWeekday: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [min](min.md) | `val min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [sec](sec.md) | `val sec: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [weekday](weekday.md) | `val weekday: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(time: `[`Time`](./index.md)`): `[`Time`](./index.md) |
| [addDay](add-day.md) | `fun addDay(onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, days: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1): `[`Time`](./index.md) |
| [clone](clone.md) | `fun clone(): `[`Time`](./index.md) |
| [getDay](get-day.md) | `fun getDay(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isAtDay](is-at-day.md) | `infix fun isAtDay(check: `[`Time`](./index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isBetween](is-between.md) | `fun isBetween(from: `[`Time`](./index.md)`, to: `[`Time`](./index.md)`, includeDay: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, rangeExtension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = if (from.representsDay || this.representsDay) 1 else 0): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [matches](matches.md) | `fun matches(day: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun matches(day: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [rem](rem.md) | `fun rem(time: `[`Time`](./index.md)`): `[`Time`](./index.md) |
| [remDay](rem-day.md) | `fun remDay(onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, days: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1): `[`Time`](./index.md) |
| [toLogString](to-log-string.md) | `fun toLogString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>`fun toString(pattern: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

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
| [getHour](get-hour.md) | `fun getHour(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = Time.now): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [of](of.md) | `fun of(time: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Time`](./index.md)<br>`fun of(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = Time.now, representsDay: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Time`](./index.md)<br>`fun of(day: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`, onlyWeek: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Time`](./index.md)<br>`fun of(day: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Time`](./index.md) |
