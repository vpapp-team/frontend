package com.molikuner.types

data class Version(
    val major: Int,
    val minor: Int,
    val patch: Int
) {

    fun isNewerThan(version: Version) =
        this.major > version.major || this.minor > version.minor || this.patch > version.patch

    override fun toString() = "v${major.toString(16)}.${minor.toString(16)}.${patch.toString(16)}"


    companion object {
        private const val VERSION_REGEXP = """^v(?>[0-9a-f]{1,2}\.){2}[0-9a-f]{1,2}$"""

        internal fun validate(version: String) = version.matches(VERSION_REGEXP.toRegex(RegexOption.IGNORE_CASE))

        fun of(version: String): Version {
            if (!Version.validate(version))
                throw IllegalArgumentException("version: '$version' has wrong format")
            val parts = version.substring(1).split(".")

            return Version(
                parts[0].toInt(16),
                parts[1].toInt(16),
                parts[2].toInt(16)
            )
        }
    }
}

fun String.toVersion() = if (Version.validate(this.trim())) Version.of(this.trim()) else null
