package com.molikuner.nigb.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.molikuner.nigb.db.entity.StandInEntity

@Dao
interface StandInDao {

    @Query("SELECT * FROM StandIns")
    fun loadAll(): LiveData<List<StandInEntity>>

    @Query("SELECT * FROM StandIns")
    fun loadAllSync(): List<StandInEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comments: List<StandInEntity>)
}