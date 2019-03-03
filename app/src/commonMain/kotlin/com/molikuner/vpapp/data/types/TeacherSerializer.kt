package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Teacher
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

@Serializer(forClass = Teacher::class)
object TeacherSerializer : KSerializer<Teacher>
