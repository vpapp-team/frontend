package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.types.Time
import kotlinx.serialization.Serializable

@Serializable
abstract class CommonResponse {
    abstract val requestTime: Time
}
