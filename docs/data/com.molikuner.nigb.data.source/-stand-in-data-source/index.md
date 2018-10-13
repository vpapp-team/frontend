[data](../../index.md) / [com.molikuner.nigb.data.source](../index.md) / [StandInDataSource](./index.md)

# StandInDataSource

`interface StandInDataSource`

### Types

| [GetStandInCallback](-get-stand-in-callback.md) | `interface GetStandInCallback : `[`DataLoadCallback`](../-data-load-callback/index.md)`<`[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`>` |
| [LoadStandInCallback](-load-stand-in-callback.md) | `interface LoadStandInCallback : `[`DataLoadCallback`](../-data-load-callback/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`>>` |

### Functions

| [deleteAllStandIns](delete-all-stand-ins.md) | `abstract fun deleteAllStandIns(callback: `[`TaskCallback`](../-task-callback/index.md)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteStandIn](delete-stand-in.md) | `abstract fun deleteStandIn(uuid: UUID, callback: `[`TaskCallback`](../-task-callback/index.md)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getStandIn](get-stand-in.md) | `abstract fun getStandIn(uuid: UUID, callback: `[`GetStandInCallback`](-get-stand-in-callback.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getStandIns](get-stand-ins.md) | `abstract fun getStandIns(callback: `[`LoadStandInCallback`](-load-stand-in-callback.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refreshStandIns](refresh-stand-ins.md) | `abstract fun refreshStandIns(callback: `[`TaskCallback`](../-task-callback/index.md)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [saveStandIn](save-stand-in.md) | `abstract fun saveStandIn(standIn: `[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`, callback: `[`TaskCallback`](../-task-callback/index.md)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [StandInLocalDataSource](../../com.molikuner.nigb.data.local.data-source/-stand-in-local-data-source/index.md) | `class StandInLocalDataSource : `[`StandInDataSource`](./index.md) |
| [StandInRemoteDataSource](../../com.molikuner.nigb.data.remote/-stand-in-remote-data-source/index.md) | `object StandInRemoteDataSource : `[`StandInDataSource`](./index.md) |

