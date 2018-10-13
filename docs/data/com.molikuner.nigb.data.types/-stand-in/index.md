[data](../../index.md) / [com.molikuner.nigb.data.types](../index.md) / [StandIn](./index.md)

# StandIn

`data class StandIn`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StandIn(id: UUID, dropped: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, date: Time, room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, origSubject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, origTeacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, clazz: ClazzDiscriminator? = null, lesson: LessonDiscriminator? = null)` |

### Properties

| Name | Summary |
|---|---|
| [clazz](clazz.md) | `val clazz: ClazzDiscriminator?` |
| [date](date.md) | `val date: Time` |
| [dropped](dropped.md) | `val dropped: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [id](id.md) | `val id: UUID` |
| [lesson](lesson.md) | `val lesson: LessonDiscriminator?` |
| [message](message.md) | `val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [origSubject](orig-subject.md) | `val origSubject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [origTeacher](orig-teacher.md) | `val origTeacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [room](room.md) | `val room: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [subject](subject.md) | `val subject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [teacher](teacher.md) | `val teacher: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`JSONArray`](https://developer.android.com/reference/org/json/JSONArray.html)`): `[`StandIn`](./index.md) |
