[app](../../index.md) / [com.molikuner.vpapp.types.data](../index.md) / [StandIn](./index.md)

# StandIn

`data class StandIn`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StandIn(id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`, dropped: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, date: `[`Time`](../../com.molikuner.types/-time/index.md)`, room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, origSubject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, origTeacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, clazz: `[`ClazzDiscriminator`](../-clazz-discriminator/index.md)`? = null, lesson: `[`LessonDiscriminator`](../-lesson-discriminator/index.md)`? = null)` |

### Properties

| Name | Summary |
|---|---|
| [clazz](clazz.md) | `val clazz: `[`ClazzDiscriminator`](../-clazz-discriminator/index.md)`?` |
| [date](date.md) | `val date: `[`Time`](../../com.molikuner.types/-time/index.md) |
| [dropped](dropped.md) | `val dropped: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [id](id.md) | `val id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md) |
| [lesson](lesson.md) | `val lesson: `[`LessonDiscriminator`](../-lesson-discriminator/index.md)`?` |
| [message](message.md) | `val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [origSubject](orig-subject.md) | `val origSubject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [origTeacher](orig-teacher.md) | `val origTeacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [room](room.md) | `val room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [subject](subject.md) | `val subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [teacher](teacher.md) | `val teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`StandIn`](./index.md) |
