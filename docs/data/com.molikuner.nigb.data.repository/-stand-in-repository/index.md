[data](../../index.md) / [com.molikuner.nigb.data.repository](../index.md) / [StandInRepository](./index.md)

# StandInRepository

`class StandInRepository`

### Properties

| Name | Summary |
|---|---|
| [cacheIsDirty](cache-is-dirty.md) | `val cacheIsDirty: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getStandInFromCache](get-stand-in-from-cache.md) | `fun getStandInFromCache(uuid: UUID): `[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`?` |
| [getStandIns](get-stand-ins.md) | `fun getStandIns(from: Time, to: Time): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`>` |
| [getStandInsOfDay](get-stand-ins-of-day.md) | `fun getStandInsOfDay(day: Time): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StandIn`](../../com.molikuner.nigb.data.types/-stand-in/index.md)`>` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `fun getInstance(standInRemoteDataSource: `[`StandInRemoteDataSource`](../../com.molikuner.nigb.data.remote/-stand-in-remote-data-source/index.md)`, standInLocalDataSource: `[`StandInLocalDataSource`](../../com.molikuner.nigb.data.local.data-source/-stand-in-local-data-source/index.md)`): `[`StandInRepository`](./index.md) |
