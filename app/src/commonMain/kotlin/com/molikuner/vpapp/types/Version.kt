package com.molikuner.vpapp.types

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializable(with = Version.Companion::class)
data class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
) {
    constructor(
        versionString: String,
        versionSplits: List<String> = versionString.split("""[v.]""".toRegex()).filter { it.isNotEmpty() }
    ) : this(
        major = versionSplits.getOrNull(0)?.toIntOrNull(RADIX) ?: 0,
        minor = versionSplits.getOrNull(1)?.toIntOrNull(RADIX) ?: 0,
        patch = versionSplits.getOrNull(2)?.toIntOrNull(RADIX) ?: 0
    ) {
        // TODO check format
    }

    override fun toString(): String {
        return "v${major.toString(RADIX)}.${minor.toString(RADIX)}.${patch.toString(RADIX)}"
    }

    @Serializer(forClass = Version::class)
    companion object : KSerializer<Version> {
        private const val RADIX = 16

        fun serializer(): KSerializer<Version> = Version

        override val descriptor: SerialDescriptor = StringDescriptor.withName("Version")

        override fun deserialize(decoder: Decoder): Version {
            return Version(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: Version) {
            encoder.encodeString(obj.toString())
        }
    }
}
