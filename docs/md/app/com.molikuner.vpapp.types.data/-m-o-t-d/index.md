[app](../../index.md) / [com.molikuner.vpapp.types.data](../index.md) / [MOTD](./index.md)

# MOTD

`data class MOTD`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MOTD(id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`, type: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, date: `[`Time`](../../com.molikuner.types/-time/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [date](date.md) | `val date: `[`Time`](../../com.molikuner.types/-time/index.md) |
| [id](id.md) | `val id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md) |
| [message](message.md) | `val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [type](type.md) | `val type: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MOTD`](./index.md) |
