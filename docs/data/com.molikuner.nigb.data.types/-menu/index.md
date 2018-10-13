[data](../../index.md) / [com.molikuner.nigb.data.types](../index.md) / [Menu](./index.md)

# Menu

`data class Menu`

Data class for Menu

This data class defines a menu and is used in the
[room database](#)

### Constructors

| [&lt;init&gt;](-init-.md) | `Menu(id: UUID, day: Time, default: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, vegetarian: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, dessert: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, evening: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null)`<br>Data class for Menu |

### Properties

| [day](day.md) | `val day: Time`<br>is a [Time](#) which defines the day for the menu |
| [default](default.md) | `val default: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>is the default meal |
| [dessert](dessert.md) | `val dessert: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>is the dessert |
| [evening](evening.md) | `val evening: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>is the special hot evening meal |
| [id](id.md) | `val id: UUID`<br>is a [UUID](#) which is used as primary key |
| [vegetarian](vegetarian.md) | `val vegetarian: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>is the vegetarian meal |

### Companion Object Functions

| [of](of.md) | `fun of(json: `[`JSONArray`](https://developer.android.com/reference/org/json/JSONArray.html)`): `[`Menu`](./index.md)<br>Function to create a menu of a json |

