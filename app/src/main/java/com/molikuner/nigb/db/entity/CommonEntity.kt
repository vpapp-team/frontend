package com.molikuner.nigb.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
abstract class CommonEntity(UUID: String) {
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    val uuid: String =
        if (UUID.matches(CommonEntity.UUID_REGEX)) UUID else throw IllegalArgumentException("UUID does not match")

    companion object {
        private val UUID_REGEX = """^[a-z0-9.\-_+]+@[a-z0-9.\-_+]+$""".toRegex(RegexOption.IGNORE_CASE)
    }

    override fun equals(other: Any?): Boolean {
        return other is CommonEntity && other.uuid == this.uuid
    }

    override fun hashCode(): Int {
        return this.uuid.hashCode()
    }
}