package com.molikuner.vpapp.data.local

import android.content.Context
import com.molikuner.vpapp.util.Singleton
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

private val driverSingleton = Singleton<SqlDriver>()

internal actual val driver: SqlDriver
    get() = driverSingleton.getValue()


fun initDB(applicationContext: Context) {
    driverSingleton.setValue(
            AndroidSqliteDriver(Database.Schema, applicationContext, "data.db")
    )
}
