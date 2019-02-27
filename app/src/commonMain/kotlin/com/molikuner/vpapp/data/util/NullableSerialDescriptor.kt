package com.molikuner.vpapp.util

import kotlinx.serialization.SerialDescriptor

class NullableSerialDescriptor(
    override val isNullable: Boolean,
    original: SerialDescriptor
) : SerialDescriptor by original

fun SerialDescriptor.nullable(isNullable: Boolean = true): SerialDescriptor = NullableSerialDescriptor(isNullable, this)
