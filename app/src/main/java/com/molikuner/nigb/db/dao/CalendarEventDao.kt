package com.molikuner.nigb.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.molikuner.nigb.db.entity.CalendarEventEntity

@Dao
interface CalendarEventDao {

    @Query("SELECT * FROM CalendarEvents")
    fun loadAll(): LiveData<List<CalendarEventEntity>>

    @Query("SELECT * FROM CalendarEvents")
    fun loadAllSync(): List<CalendarEventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comments: List<CalendarEventEntity>)
}