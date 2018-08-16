package com.molikuner.nigb.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.molikuner.nigb.db.entity.LastUpdateEntity

@Dao
interface LastUpdateDao {

    @Query("SELECT * FROM LastUpdates")
    fun loadAll(): LiveData<List<LastUpdateEntity>>

    @Query("SELECT * FROM LastUpdates")
    fun loadAllSync(): List<LastUpdateEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comments: List<LastUpdateEntity>)
}