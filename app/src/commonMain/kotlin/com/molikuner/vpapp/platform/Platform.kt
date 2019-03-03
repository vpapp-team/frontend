package com.molikuner.vpapp.platform

import com.molikuner.vpapp.types.Version

expect object Platform {
    val VERSION: Version
    val PLATFORM: String
    val currentTimeMillis: Long
}
