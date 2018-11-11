[app](../../index.md) / [com.molikuner.vpapp.usecase](../index.md) / [UseCase](./index.md)

# UseCase

`abstract class UseCase<out R : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UseCase()` |

### Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | `abstract operator suspend fun invoke(): `[`Result`](../../com.molikuner.util/-result/index.md)`<`[`R`](index.md#R)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [GetCurrentMenuUseCase](../-get-current-menu-use-case/index.md) | `class GetCurrentMenuUseCase : `[`UseCase`](./index.md)`<`[`Menu`](../../com.molikuner.vpapp.types.data/-menu/index.md)`>` |
| [GetNextLessonUseCase](../-get-next-lesson-use-case/index.md) | `class GetNextLessonUseCase : `[`UseCase`](./index.md)`<`[`Lesson`](../../com.molikuner.vpapp.types.data/-lesson/index.md)`>` |
| [GetStandInForLessonUseCase](../-get-stand-in-for-lesson-use-case/index.md) | `class GetStandInForLessonUseCase : `[`UseCase`](./index.md)`<`[`StandIn`](../../com.molikuner.vpapp.types.data/-stand-in/index.md)`>` |
| [GetTodaysCalendarEventsUseCase](../-get-todays-calendar-events-use-case/index.md) | `class GetTodaysCalendarEventsUseCase : `[`UseCase`](./index.md)`<`[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CalendarEvent`](../../com.molikuner.vpapp.types.data/-calendar-event/index.md)`>>` |
