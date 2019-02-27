package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.types.Time
import kotlinx.serialization.Serializable

@Serializable
abstract class CommonResponse(
    open val requestTime: Time
)
