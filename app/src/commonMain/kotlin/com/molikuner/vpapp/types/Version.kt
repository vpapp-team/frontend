package com.molikuner.vpapp.types

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializable
data class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
) {
    constructor(
        versionString: String,
        versionSplits: List<String> = versionString.split("""[v.]""".toRegex()).filter { it.isNotEmpty() }
    ): this(
        major = versionSplits.getOrNull(0)?.toIntOrNull(16) ?: 0,
        minor = versionSplits.getOrNull(1)?.toIntOrNull(16) ?: 0,
        patch = versionSplits.getOrNull(2)?.toIntOrNull(16) ?: 0
    ) {
        // TODO check format
    }

    override fun toString(): String {
        return "v${major.toString(16)}.${minor.toString(16)}.${patch.toString(16)}"
    }

    @Serializer(forClass = Version::class)
    companion object : KSerializer<Version> {
        override val descriptor: SerialDescriptor = StringDescriptor.withName("Version")

        override fun deserialize(decoder: Decoder): Version {
            return Version(decoder.decodeString())
        }

        override fun serialize(encoder: Encoder, obj: Version) {
            encoder.encodeString(obj.toString())
        }
    }
}