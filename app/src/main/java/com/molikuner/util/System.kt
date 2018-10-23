package com.molikuner.util

import com.molikuner.types.Version
import com.molikuner.types.toVersion
import sample.BuildConfig
import java.lang.System

actual object System {
    actual val platform: String
        get() = "android"
    actual val version: Version
        get() = BuildConfig.VERSION_NAME.toVersion()!!
    actual val currentTimeMillis: Long
        get() = System.currentTimeMillis()
}