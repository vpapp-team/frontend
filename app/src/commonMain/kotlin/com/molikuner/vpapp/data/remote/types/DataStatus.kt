package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.Serializable

@Serializable
data class DataStatus(val has: List<UUID>)