package com.molikuner.nigb.types

import com.molikuner.types.Time

interface LastUpdate {
    fun isDue(serverTime: Long): Boolean {
        return serverTime > this.lastUpdate().time
    }

    fun lastUpdate(): Time
}