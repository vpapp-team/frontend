[types](../../index.md) / [com.molikuner.nigb.types](../index.md) / [LessonRange](./index.md)

# LessonRange

`data class LessonRange`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LessonRange(lesson: `[`LessonDiscriminator`](../-lesson-discriminator/index.md)`, time: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [lesson](lesson.md) | `val lesson: `[`LessonDiscriminator`](../-lesson-discriminator/index.md) |
| [time](time.md) | `val time: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`JSONObject`](https://developer.android.com/reference/org/json/JSONObject.html)`): `[`LessonRange`](./index.md) |
| [validate](validate.md) | `fun validate(time: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
