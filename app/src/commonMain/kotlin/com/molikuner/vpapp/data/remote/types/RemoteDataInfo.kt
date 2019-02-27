package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

@Serializable
data class RemoteDataInfo<T, K : KSerializer<T>>(
    val requestTime: Time,
    val add: List<T>,
    val remove: List<UUID>
)
