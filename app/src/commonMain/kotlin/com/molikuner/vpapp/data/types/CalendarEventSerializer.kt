package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.CalendarEvent
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.serializer
import com.molikuner.vpapp.util.use
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer

@Serializer(forClass = CalendarEvent::class)
object CalendarEventSerializer : KSerializer<CalendarEvent> {
    override val descriptor: SerialDescriptor
        get() = object : SerialArrayClassDescImpl("CalendarEvent") {
            init {
                addElement(CalendarEvent::id, 0, UUID.descriptor)
                addElement(CalendarEvent::start, 1, Time.descriptor)
                addElement(CalendarEvent::end, 2, Time.descriptor)
                addElement(CalendarEvent::summary, 3)
                addElement(CalendarEvent::description, 4)
                addElement(CalendarEvent::location, 5)
                addElement(CalendarEvent::isRecurring, 6)
                addElement(CalendarEvent::humanRecurrenceRule, 7, true)
            }
        }

    override fun deserialize(decoder: Decoder): CalendarEvent {
        return decoder.use(descriptor) {
            val isRecurring: Boolean
            return@use CalendarEvent.Impl(
                id = decodeSerializableElement(0, UUID.serializer()),
                start = decodeSerializableElement(1, Time.serializer()),
                end = decodeSerializableElement(2, Time.serializer()),
                summary = decodeStringElement(3),
                description = decodeNullableStringElement(4),
                location = decodeNullableStringElement(5),
                isRecurring = decodeBooleanElement(6).also {
                    isRecurring = it
                },
                humanRecurrenceRule = if (isRecurring) decodeStringElement(7) else null
            )
        }
    }

    override fun patch(decoder: Decoder, old: CalendarEvent): CalendarEvent {
        return deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, obj: CalendarEvent) {
        return encoder.use(descriptor) {
            encodeSerializableElement(0, UUID.serializer(), obj.id)
            encodeSerializableElement(1, Time.serializer(), obj.start)
            encodeSerializableElement(2, Time.serializer(), obj.end)
            encodeStringElement(3, obj.summary)
            encodeNullableStringElement(4, obj.description)
            encodeNullableStringElement(5, obj.location)
            encodeBooleanElement(6, obj.isRecurring)
            obj.humanRecurrenceRule?.also {
                if (obj.isRecurring) encodeStringElement(7, it)
            }
        }
    }
}
