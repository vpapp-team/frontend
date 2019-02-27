package com.molikuner.vpapp.platform

import com.molikuner.vpapp.BuildConfig
import com.molikuner.vpapp.types.Version

actual object Platform {
    actual val VERSION: Version = Version(BuildConfig.VERSION_NAME)
    actual val PLATFORM: String = "android"
}