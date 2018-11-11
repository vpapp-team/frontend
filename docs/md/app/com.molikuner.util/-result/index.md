[app](../../index.md) / [com.molikuner.util](../index.md) / [Result](./index.md)

# Result

`sealed class Result<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

### Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `data class Error : `[`Result`](./index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| [Success](-success/index.md) | `data class Success<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Result`](./index.md)`<`[`T`](-success/index.md#T)`>` |

### Properties

| Name | Summary |
|---|---|
| [asSuccess](as-success.md) | `val asSuccess: `[`Success`](-success/index.md)`<`[`T`](index.md#T)`>?` |

### Extension Functions

| Name | Summary |
|---|---|
| [isErrored](../is-errored.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Result`](./index.md)`<`[`T`](../is-errored.md#T)`>.isErrored(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `data class Error : `[`Result`](./index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| [Success](-success/index.md) | `data class Success<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Result`](./index.md)`<`[`T`](-success/index.md#T)`>` |
