package com.molikuner.nigb.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.molikuner.nigb.types.LastUpdate
import com.molikuner.types.Time

@Entity(tableName = "LastUpdates")
class LastUpdateEntity(
    @PrimaryKey @ColumnInfo(name = "category") val category: Number,
    @ColumnInfo(name = "lastUpdate") val lastUpdate: Time
) : LastUpdate {
    override fun isDue(serverTime: Long): Boolean {
        // TODO check based on type if is it maybe earlier due to request
        // (StandIn at least all 6h)
        return super.isDue(serverTime)
    }

    override fun lastUpdate(): Time = this.lastUpdate

}