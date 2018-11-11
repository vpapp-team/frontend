[app](../../index.md) / [com.molikuner.vpapp.types.data](../index.md) / [Menu](./index.md)

# Menu

`data class Menu`

Data class for Menu

This data class defines a menu

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Menu(id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)`, day: `[`Time`](../../com.molikuner.types/-time/index.md)`, default: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, vegetarian: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, dessert: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, evening: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null)`<br>Data class for Menu |

### Properties

| Name | Summary |
|---|---|
| [day](day.md) | `val day: `[`Time`](../../com.molikuner.types/-time/index.md)<br>is a [Time](../../com.molikuner.types/-time/index.md) which defines the day for the menu |
| [default](default.md) | `val default: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>is the default meal |
| [dessert](dessert.md) | `val dessert: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>is the dessert |
| [evening](evening.md) | `val evening: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>is the special hot evening meal |
| [id](id.md) | `val id: `[`UUID`](../../com.molikuner.types/-u-u-i-d/index.md)<br>is a [UUID](../../com.molikuner.types/-u-u-i-d/index.md) which is used as primary key |
| [vegetarian](vegetarian.md) | `val vegetarian: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>is the vegetarian meal |

### Companion Object Functions

| Name | Summary |
|---|---|
| [of](of.md) | `fun of(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Menu`](./index.md)<br>Function to create a menu of a json |
