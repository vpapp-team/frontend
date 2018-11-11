[app](../../index.md) / [com.molikuner.util](../index.md) / [APIResult](./index.md)

# APIResult

`sealed class APIResult<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

### Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `sealed class Error : `[`APIResult`](./index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| [NothingNew](-nothing-new.md) | `object NothingNew : `[`APIResult`](./index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| [Success](-success/index.md) | `data class Success<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`APIResult`](./index.md)`<`[`T`](-success/index.md#T)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `sealed class Error : `[`APIResult`](./index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| [NothingNew](-nothing-new.md) | `object NothingNew : `[`APIResult`](./index.md)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| [Success](-success/index.md) | `data class Success<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`APIResult`](./index.md)`<`[`T`](-success/index.md#T)`>` |
