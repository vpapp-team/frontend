package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Timetable
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

@Serializer(forClass = Timetable::class)
object TimetableSerializer : KSerializer<Timetable>
