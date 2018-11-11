[app](../index.md) / [com.molikuner.vpapp.types.responses](./index.md)

## Package com.molikuner.vpapp.types.responses

### Types

| Name | Summary |
|---|---|
| [Response](-response/index.md) | `abstract class Response` |
| [SimpleResponse](-simple-response/index.md) | `data class SimpleResponse<T> : `[`Response`](-response/index.md) |
| [TimetablesResponse](-timetables-response/index.md) | `data class TimetablesResponse : `[`Response`](-response/index.md) |
| [UpdatesResponse](-updates-response/index.md) | `data class UpdatesResponse : `[`Response`](-response/index.md) |

### Type Aliases

| Name | Summary |
|---|---|
| [CalendarResponse](-calendar-response.md) | `typealias CalendarResponse = `[`SimpleResponse`](-simple-response/index.md)`<`[`CalendarEvent`](../com.molikuner.vpapp.types.data/-calendar-event/index.md)`>` |
| [MenuResponse](-menu-response.md) | `typealias MenuResponse = `[`SimpleResponse`](-simple-response/index.md)`<`[`Menu`](../com.molikuner.vpapp.types.data/-menu/index.md)`>` |
| [StandInsResponse](-stand-ins-response.md) | `typealias StandInsResponse = `[`SimpleResponse`](-simple-response/index.md)`<`[`StandIn`](../com.molikuner.vpapp.types.data/-stand-in/index.md)`>` |
| [TeachersResponse](-teachers-response.md) | `typealias TeachersResponse = `[`SimpleResponse`](-simple-response/index.md)`<`[`Teacher`](../com.molikuner.vpapp.types.data/-teacher/index.md)`>` |
