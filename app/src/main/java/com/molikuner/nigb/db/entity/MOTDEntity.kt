package com.molikuner.nigb.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.molikuner.nigb.types.MOTD
import com.molikuner.types.Time
import org.json.JSONArray

@Entity(tableName = "MOTDs")
class MOTDEntity(
    UUID: String,
    @ColumnInfo(name = "type") val type: Number,
    @ColumnInfo(name = "message") val message: String?,
    @ColumnInfo(name = "date") val date: Time
) : CommonEntity(UUID), MOTD {
    constructor(json: JSONArray) : this(
        UUID = json.getString(0),
        type = json.getInt(2),
        date = Time.of(json.getString(3)),
        message = json.getString(4)
    )
}