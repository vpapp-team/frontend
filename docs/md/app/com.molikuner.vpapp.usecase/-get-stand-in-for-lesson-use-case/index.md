[app](../../index.md) / [com.molikuner.vpapp.usecase](../index.md) / [GetStandInForLessonUseCase](./index.md)

# GetStandInForLessonUseCase

`class GetStandInForLessonUseCase : `[`UseCase`](../-use-case/index.md)`<`[`StandIn`](../../com.molikuner.vpapp.types.data/-stand-in/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GetStandInForLessonUseCase(getNextLesson: `[`GetNextLessonUseCase`](../-get-next-lesson-use-case/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [getNextLesson](get-next-lesson.md) | `val getNextLesson: `[`GetNextLessonUseCase`](../-get-next-lesson-use-case/index.md) |

### Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | `operator suspend fun invoke(): `[`Result`](../../com.molikuner.util/-result/index.md)`<`[`StandIn`](../../com.molikuner.vpapp.types.data/-stand-in/index.md)`>`<br>`operator suspend fun invoke(lesson: `[`Lesson`](../../com.molikuner.vpapp.types.data/-lesson/index.md)`): `[`Result`](../../com.molikuner.util/-result/index.md)`<`[`StandIn`](../../com.molikuner.vpapp.types.data/-stand-in/index.md)`>` |
