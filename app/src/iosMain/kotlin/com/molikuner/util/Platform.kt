package com.molikuner.util

import com.molikuner.types.Version
import kotlin.system.getTimeMillis

actual object Platform {
    actual val platform: String = "ios"
    actual val version: Version
        get() = TODO("version not implemented -> com.molikuner.types.Version")
    actual val currentTimeMillis: Long
        get() = getTimeMillis()
}
