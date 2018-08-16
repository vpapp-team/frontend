package com.molikuner.nigb.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.molikuner.nigb.db.entity.MOTDEntity

@Dao
interface MOTDDao {

    @Query("SELECT * FROM MOTDs")
    fun loadAll(): LiveData<List<MOTDEntity>>

    @Query("SELECT * FROM MOTDs")
    fun loadAllSync(): List<MOTDEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comments: List<MOTDEntity>)
}