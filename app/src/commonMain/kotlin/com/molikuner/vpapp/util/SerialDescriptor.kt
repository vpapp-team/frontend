package com.molikuner.vpapp.util

import kotlinx.serialization.internal.BooleanDescriptor
import kotlinx.serialization.internal.StringDescriptor
import kotlin.reflect.KProperty1

fun StringDescriptor.of(property: KProperty1<*, String?>) =
    StringDescriptor.nullable(property.returnType.isMarkedNullable)

fun BooleanDescriptor.of(property: KProperty1<*, Boolean?>) =
    BooleanDescriptor.nullable(property.returnType.isMarkedNullable)
