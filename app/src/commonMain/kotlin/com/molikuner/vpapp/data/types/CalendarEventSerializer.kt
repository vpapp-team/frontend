package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.CalendarEvent
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

@Serializer(forClass = CalendarEvent::class)
object CalendarEventSerializer : KSerializer<CalendarEvent>
