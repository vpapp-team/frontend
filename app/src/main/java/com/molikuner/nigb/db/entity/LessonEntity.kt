package com.molikuner.nigb.db.entity

import android.arch.persistence.room.TypeConverter

class LessonEntity(UUID: String) : CommonEntity(UUID) {
    class Discriminator(discriminator: String) {
        companion object {

            @TypeConverter
            fun toString(discriminator: Discriminator?): String? {
                return discriminator?.toString()
            }

            @TypeConverter
            fun toDiscriminator(discriminator: String?): Discriminator? {
                if (discriminator == null) return null
                return Discriminator(discriminator)
            }
        }
    }
}