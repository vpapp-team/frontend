package com.molikuner.vpapp.types

import kotlinx.serialization.Serializable

@Serializable
data class Range(
    val begin: Time,
    val end: Time
)