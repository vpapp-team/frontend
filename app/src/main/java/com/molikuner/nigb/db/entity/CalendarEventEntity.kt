package com.molikuner.nigb.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.molikuner.nigb.types.CalendarEvent
import com.molikuner.types.Time
import org.json.JSONArray

@Entity(tableName = "CalendarEvents")
class CalendarEventEntity(
    UUID: String,
    @ColumnInfo(name = "description") private val description: String? = null,
    @ColumnInfo(name = "end") private val end: Time,
    @ColumnInfo(name = "human_recurring_rule") private val humanRecurringRule: String? = null,
    @ColumnInfo(name = "location") private val location: String? = null,
    @ColumnInfo(name = "start") private val start: Time,
    @ColumnInfo(name = "summary") private val summary: String
) : CommonEntity(UUID), CalendarEvent {
    constructor(json: JSONArray) : this(
        UUID = json.getString(0),
        start = Time.of(json.getString(1)),
        end = Time.of(json.getString(2)),
        summary = json.getString(3),
        description = json.getString(4),
        location = json.getString(5),
        humanRecurringRule = json.getString(6)
    )
}