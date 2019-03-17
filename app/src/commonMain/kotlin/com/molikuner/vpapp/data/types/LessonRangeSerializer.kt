package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.LessonRange
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

@Serializer(forClass = LessonRange::class)
object LessonRangeSerializer : KSerializer<LessonRange>
