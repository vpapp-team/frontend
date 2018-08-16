package com.molikuner.nigb.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.TypeConverters
import com.molikuner.nigb.types.StandIn
import com.molikuner.types.Time
import org.json.JSONArray

@Entity(tableName = "StandIns")
class StandInEntity(
    UUID: String,
    @ColumnInfo(name = "dropped") val dropped: Boolean,
    @ColumnInfo(name = "date") val date: Time,
    @ColumnInfo(name = "room") val room: String?,
    @ColumnInfo(name = "message") val message: String?,
    @ColumnInfo(name = "subject") val subject: String?,
    @ColumnInfo(name = "teacher") val teacher: String?,
    @ColumnInfo(name = "orig_subject") val origSubject: String?,
    @ColumnInfo(name = "orig_teacher") val origTeacher: String?,
    @ColumnInfo(name = "clazz") @TypeConverters(ClazzEntity.Discriminator::class) val clazz: ClazzEntity.Discriminator?,
    @ColumnInfo(name = "lesson") @TypeConverters(LessonEntity.Discriminator::class) val lesson: LessonEntity.Discriminator?
) : CommonEntity(UUID), StandIn {
    constructor(json: JSONArray) : this(
        UUID = json.getString(0),
        date = Time.of(json.getString(3)),
        message = json.getString(4),
        teacher = json.getString(5),
        subject = json.getString(6),
        lesson = if (json.isNull(7)) null else LessonEntity.Discriminator(json.getString(7)),
        clazz = if (json.isNull(8)) null else ClazzEntity.Discriminator(json.getString(8)),
        room = json.getString(9),
        origTeacher = json.getString(10),
        origSubject = json.getString(11),
        dropped = json.getBoolean(12)
    )
}