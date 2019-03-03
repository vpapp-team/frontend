package com.molikuner.vpapp.data.repository

import com.molikuner.vpapp.types.Time

internal data class CacheState<T>(
    val state: T,
    val lastUpdate: Time.Timestamp = Time.now()
)
