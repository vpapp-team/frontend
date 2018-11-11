[app](../../index.md) / [com.molikuner.vpapp.types.data](../index.md) / [Lesson](./index.md)

# Lesson

`data class Lesson`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Lesson(id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`, weekday: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, lesson: `[`LessonDiscriminator`](../-lesson-discriminator/index.md)`, room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, clazz: `[`ClazzDiscriminator`](../-clazz-discriminator/index.md)`, length: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, regularity: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [clazz](clazz.md) | `val clazz: `[`ClazzDiscriminator`](../-clazz-discriminator/index.md) |
| [id](id.md) | `val id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md) |
| [length](length.md) | `val length: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [lesson](lesson.md) | `val lesson: `[`LessonDiscriminator`](../-lesson-discriminator/index.md) |
| [regularity](regularity.md) | `val regularity: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [room](room.md) | `val room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [subject](subject.md) | `val subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [teacher](teacher.md) | `val teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [weekday](weekday.md) | `val weekday: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [REGUALRITY_ALWAYS](-r-e-g-u-a-l-r-i-t-y_-a-l-w-a-y-s.md) | `const val REGUALRITY_ALWAYS: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [REGUALRITY_EVEN](-r-e-g-u-a-l-r-i-t-y_-e-v-e-n.md) | `const val REGUALRITY_EVEN: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [REGUALRITY_UNEVEN](-r-e-g-u-a-l-r-i-t-y_-u-n-e-v-e-n.md) | `const val REGUALRITY_UNEVEN: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Lesson`](./index.md) |
