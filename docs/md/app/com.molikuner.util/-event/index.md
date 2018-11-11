[app](../../index.md) / [com.molikuner.util](../index.md) / [Event](./index.md)

# Event

`open class Event<out T>`

**Platform and version requirements:** android

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Event(content: `[`T`](index.md#T)`)` |

### Properties

| Name | Summary |
|---|---|
| [consumed](consumed.md) | `var consumed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [consume](consume.md) | `fun consume(): `[`T`](index.md#T)`?`<br>Consume the content if it's not been consumed yet |
