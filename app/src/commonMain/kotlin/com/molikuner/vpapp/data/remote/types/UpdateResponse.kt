package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.data.local.LastUpdate
import com.molikuner.vpapp.data.types.LastUpdateSerializer
import com.molikuner.vpapp.types.Range
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.Version
import kotlinx.serialization.Serializable

@Serializable
data class UpdateResponse(
    override val requestTime: Time,
    @Serializable(with = LastUpdateSerializer::class) val lastUpdates: List<LastUpdate>,
    val recommendedVersion: Version,
    val minVersion: Version,
    val recommendedDays: Range.Day,
    val message: String?
) : CommonResponse()
