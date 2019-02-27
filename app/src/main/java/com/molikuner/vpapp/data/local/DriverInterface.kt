package com.molikuner.vpapp.data.local

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

private lateinit var driverSave: SqlDriver
internal actual val driver: SqlDriver
    get() = driverSave

fun DB.initDB(applicationContext: Context) {
    if (::driverSave.isInitialized) return
    driverSave = AndroidSqliteDriver(Database.Schema, applicationContext, "data.db")
}
