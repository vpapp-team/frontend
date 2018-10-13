[data](../../index.md) / [com.molikuner.nigb.data.repository](../index.md) / [MenuRepository](./index.md)

# MenuRepository

`class MenuRepository`

Role:    Fetching and storing data
    In memory cache (optional)

Dependencies:
    RemoteDataSource and/or
    LocalDataSource

Input:   Data retrieval: ids
    Data saving: T

Output:  Result

Note:    suspend functions should be used

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `infix fun get(day: Time): `[`Menu`](../../com.molikuner.nigb.data.types/-menu/index.md)`?` |
| [refreshed](refreshed.md) | `fun refreshed(): `[`MenuRepository`](./index.md)`?` |
| [requestFromRemote](request-from-remote.md) | `suspend fun requestFromRemote(): Result<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `fun getInstance(): `[`MenuRepository`](./index.md) |
