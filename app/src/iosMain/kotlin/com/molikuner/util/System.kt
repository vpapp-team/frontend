package com.molikuner.util

import com.molikuner.types.Version

actual object System {
    actual val platform: String
        get() = TODO("platform not implemented -> kotlin.String")
    actual val version: Version
        get() = TODO("version not implemented -> com.molikuner.types.Version")
    actual val currentTimeMillis: Long
        get() = TODO("currentTimeMillis not implemented -> kotlin.Long")
}