[data](../../index.md) / [com.molikuner.nigb.data.local](../index.md) / [AppDatabase](./index.md)

# AppDatabase

`abstract class AppDatabase : RoomDatabase`

### Constructors

| [&lt;init&gt;](-init-.md) | `AppDatabase()` |

### Properties

| [databaseCreated](database-created.md) | `val databaseCreated: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |

### Functions

| [calendarDao](calendar-dao.md) | `abstract fun calendarDao(): `[`CalendarEventDao`](../../com.molikuner.nigb.data.local.dao/-calendar-event-dao/index.md) |
| [lastUpdateDao](last-update-dao.md) | `abstract fun lastUpdateDao(): `[`LastUpdateDao`](../../com.molikuner.nigb.data.local.dao/-last-update-dao/index.md) |
| [motdDao](motd-dao.md) | `abstract fun motdDao(): `[`MOTDDao`](../../com.molikuner.nigb.data.local.dao/-m-o-t-d-dao/index.md) |
| [standInDao](stand-in-dao.md) | `abstract fun standInDao(): `[`StandInDao`](../../com.molikuner.nigb.data.local.dao/-stand-in-dao/index.md) |

### Companion Object Properties

| [DATABASE_NAME](-d-a-t-a-b-a-s-e_-n-a-m-e.md) | `val DATABASE_NAME: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| [getInstance](get-instance.md) | `fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`AppDatabase`](./index.md) |

