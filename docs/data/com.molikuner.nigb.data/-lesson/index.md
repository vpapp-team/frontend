[data](../../index.md) / [com.molikuner.nigb.data](../index.md) / [Lesson](./index.md)

# Lesson

`data class Lesson`

### Constructors

| [&lt;init&gt;](-init-.md) | `Lesson(id: UUID, weekday: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, lesson: LessonDiscriminator, room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, clazz: ClazzDiscriminator, length: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`, regularity: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`)` |

### Properties

| [clazz](clazz.md) | `val clazz: ClazzDiscriminator` |
| [id](id.md) | `val id: UUID` |
| [length](length.md) | `val length: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [lesson](lesson.md) | `val lesson: LessonDiscriminator` |
| [regularity](regularity.md) | `val regularity: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |
| [room](room.md) | `val room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [subject](subject.md) | `val subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [teacher](teacher.md) | `val teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [weekday](weekday.md) | `val weekday: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html) |

### Companion Object Properties

| [REGUALRITY_ALWAYS](-r-e-g-u-a-l-r-i-t-y_-a-l-w-a-y-s.md) | `const val REGUALRITY_ALWAYS: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [REGUALRITY_EVEN](-r-e-g-u-a-l-r-i-t-y_-e-v-e-n.md) | `const val REGUALRITY_EVEN: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [REGUALRITY_UNEVEN](-r-e-g-u-a-l-r-i-t-y_-u-n-e-v-e-n.md) | `const val REGUALRITY_UNEVEN: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |

### Companion Object Functions

| [of](of.md) | `fun of(json: `[`JSONArray`](https://developer.android.com/reference/org/json/JSONArray.html)`): `[`Lesson`](./index.md) |

