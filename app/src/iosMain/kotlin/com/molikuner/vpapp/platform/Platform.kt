package com.molikuner.vpapp.platform

import com.molikuner.vpapp.types.Version
import kotlin.system.getTimeMillis

actual object Platform {
    actual val VERSION: Version
        get() = TODO("property of type 'com.molikuner.vpapp.types.Version' not implemented")
    actual val PLATFORM: String
        get() = TODO("property of type 'kotlin.String' not implemented")
    actual val currentTimeMillis: Long
        get() = getTimeMillis()
}
