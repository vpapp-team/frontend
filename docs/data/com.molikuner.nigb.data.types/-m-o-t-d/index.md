[data](../../index.md) / [com.molikuner.nigb.data.types](../index.md) / [MOTD](./index.md)

# MOTD

`data class MOTD`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MOTD(id: UUID, type: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, date: Time)` |

### Properties

| Name | Summary |
|---|---|
| [date](date.md) | `val date: Time` |
| [id](id.md) | `val id: UUID` |
| [message](message.md) | `val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [type](type.md) | `val type: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`JSONArray`](https://developer.android.com/reference/org/json/JSONArray.html)`): `[`MOTD`](./index.md) |
