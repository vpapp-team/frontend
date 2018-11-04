package com.molikuner.types

data class UUID(val id: String) {
    init {
        if (!validate(this.id)) throw IllegalArgumentException("UUID $id has wrong format")
    }

    companion object {
        private const val UUID_REGEX = """^[a-z0-9.\-_+]+@[a-z0-9.\-_+]+$"""

        internal fun validate(id: String) = id.matches(UUID_REGEX.toRegex(RegexOption.IGNORE_CASE))
    }
}

fun String.toUUID() = if (UUID.validate(this.trim())) UUID(this.trim()) else null