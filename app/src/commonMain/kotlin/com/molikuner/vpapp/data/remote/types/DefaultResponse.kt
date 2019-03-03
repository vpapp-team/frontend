@file:UseSerializers(
    CalendarEventSerializer::class,
    MenuSerializer::class,
    TeacherSerializer::class,
    TimetableSerializer::class,
    LessonRangeSerializer::class
)

package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.data.local.CalendarEvent
import com.molikuner.vpapp.data.local.LessonRange
import com.molikuner.vpapp.data.local.Menu
import com.molikuner.vpapp.data.local.Teacher
import com.molikuner.vpapp.data.local.Timetable
import com.molikuner.vpapp.data.types.CalendarEventSerializer
import com.molikuner.vpapp.data.types.LessonRangeSerializer
import com.molikuner.vpapp.data.types.MenuSerializer
import com.molikuner.vpapp.data.types.TeacherSerializer
import com.molikuner.vpapp.data.types.TimetableSerializer
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
sealed class DefaultResponse<T> : CommonResponse() {
    abstract val add: List<T>
    abstract val remove: List<UUID>

    @Serializable
    data class CalendarResponse(
        override val requestTime: Time,
        override val add: List<CalendarEvent>,
        override val remove: List<UUID>
    ) : DefaultResponse<CalendarEvent>()

    @Serializable
    data class MenuResponse(
        override val requestTime: Time,
        override val add: List<Menu>,
        override val remove: List<UUID>
    ) : DefaultResponse<Menu>()

    @Serializable
    data class TeacherResponse(
        override val requestTime: Time,
        override val add: List<Teacher>,
        override val remove: List<UUID>
    ) : DefaultResponse<Teacher>()

    @Serializable
    data class TimetableResponse(
        override val requestTime: Time,
        override val add: List<Timetable>,
        override val remove: List<UUID>,
        val hours: List<LessonRange>
    ) : DefaultResponse<Timetable>()
}
