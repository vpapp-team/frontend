[data](../../index.md) / [com.molikuner.nigb.data.source](../index.md) / [DataLoadCallback](./index.md)

# DataLoadCallback

`interface DataLoadCallback<in T>`

### Functions

| [onDataLoaded](on-data-loaded.md) | `abstract fun onDataLoaded(data: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDataNotAvailable](on-data-not-available.md) | `abstract fun onDataNotAvailable(e: `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [GetStandInCallback](../-stand-in-data-source/-get-stand-in-callback.md) | `interface GetStandInCallback : `[`DataLoadCallback`](./index.md)`<`[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`>` |
| [LoadStandInCallback](../-stand-in-data-source/-load-stand-in-callback.md) | `interface LoadStandInCallback : `[`DataLoadCallback`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`>>` |

