package com.molikuner.vpapp.data.local

import com.molikuner.vpapp.types.ClazzDiscriminator
import com.molikuner.vpapp.types.LessonDiscriminator
import com.molikuner.vpapp.types.ListAdapter
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.serialization.internal.StringSerializer

internal expect val driver: SqlDriver

object DB {
    private val db by lazy {
        Database(
            driver = driver,
            StandInAdapter = StandIn.Adapter(
                idAdapter = UUID.Adapter,
                dayAdapter = Time.Day.Adapter,
                clazzAdapter = ClazzDiscriminator.Adapter,
                lessonAdapter = LessonDiscriminator.Adapter
            ),
            MOTDAdapter = MOTD.Adapter(
                idAdapter = UUID.Adapter,
                dayAdapter = Time.Day.Adapter,
                typeAdapter = EnumColumnAdapter()
            ),
            CalendarEventAdapter = CalendarEvent.Adapter(
                idAdapter = UUID.Adapter,
                startAdapter = Time.Adapter,
                endAdapter = Time.Adapter
            ),
            LastUpdateAdapter = LastUpdate.Adapter(
                categoryAdapter = EnumColumnAdapter(),
                lastUpdateAdapter = Time.Timestamp.Adapter
            ),
            LessonAdapter = Lesson.Adapter(
                idAdapter = UUID.Adapter,
                masterAdapter = UUID.Adapter,
                dayAdapter = EnumColumnAdapter(),
                lessonAdapter = LessonDiscriminator.Adapter,
                clazzAdapter = ClazzDiscriminator.Adapter,
                regularityAdapter = EnumColumnAdapter()
            ),
            MenuAdapter = Menu.Adapter(
                idAdapter = UUID.Adapter,
                dayAdapter = Time.Day.Adapter
            ),
            TeacherAdapter = Teacher.Adapter(
                idAdapter = UUID.Adapter,
                subjectsAdapter = ListAdapter(StringSerializer),
                mailAdapter = UUID.Adapter,
                commentsAdapter = ListAdapter(StringSerializer)
            ),
            TimetableAdapter = Timetable.Adapter(
                idAdapter = UUID.Adapter,
                typeAdapter = EnumColumnAdapter(),
                activationAdapter = Time.Adapter
            ),
            LessonRangeAdapter = LessonRange.Adapter(
                discriminatorAdapter = LessonDiscriminator.Adapter
            )
        )
    }
    val queries by lazy { db.databaseQueries }
}
