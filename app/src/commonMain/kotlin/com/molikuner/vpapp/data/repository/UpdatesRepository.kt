package com.molikuner.vpapp.data.repository

import com.molikuner.vpapp.data.local.DB
import com.molikuner.vpapp.data.remote.API
import com.molikuner.vpapp.data.remote.types.UpdateResponse
import com.molikuner.vpapp.data.types.LastUpdateTypes
import com.molikuner.vpapp.data.util.APIResult
import com.molikuner.vpapp.data.util.FatalException
import com.molikuner.vpapp.platform.Platform
import com.molikuner.vpapp.types.Range
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.Version

object UpdatesRepository {
    private val dbCache: MutableMap<LastUpdateTypes, CacheState<Time.Timestamp>> = mutableMapOf()
    private val remoteCache: MutableMap<LastUpdateTypes, CacheState<Time.Timestamp>> = mutableMapOf()
    private var messageString: String? = null
    val message: String?
        get() = messageString?.also {
            messageString = null
        }
    private var recommendedDays: CacheState<Range.Day>? = null
    private var minVersion: CacheState<Version>? = null

    suspend fun recommendedDays(): Range.Day {
        return recommendedDays?.takeIf { it.lastUpdate.unix < Platform.currentTimeMillis - 3600000 }?.state ?: request {
            recommendedDays()
        }
    }

    suspend fun minVersion(): Version {
        return minVersion?.takeIf { it.lastUpdate.unix < Platform.currentTimeMillis - 3600000 }?.state ?: request {
            minVersion()
        }
    }

    suspend fun lastRemoteUpdate(type: LastUpdateTypes, retry: Boolean = true): Time.Timestamp {
        return remoteCache[type]?.takeIf { it.lastUpdate.unix < Platform.currentTimeMillis - 300000 }?.state
            ?: if (!retry) throw FatalException(
                APIResult.Error.LocalError(
                    "remote doesn't provide ${type.name}",
                    IllegalStateException(type.name)
                )
            ) else request { lastRemoteUpdate(type, false) }
    }

    suspend fun lastDBUpdate(type: LastUpdateTypes): Time.Timestamp {
        return dbCache[type]?.state ?: DB.queries.getLastUpdate(type).executeAsOne().also {
            dbCache[type] = CacheState(it)
        }
    }

    suspend fun setLastUpdate(type: LastUpdateTypes, timestamp: Time.Timestamp) {
        return DB.queries.updateLastUpdate(timestamp, type).also {
            dbCache[type] = CacheState(timestamp)
        }
    }

    suspend fun resetLastUpdate(type: LastUpdateTypes) {
        return DB.queries.resetLastUpdate(type).also {
            dbCache.remove(type)
        }
    }

    suspend fun shouldRequest(type: LastUpdateTypes): Boolean {
        return lastRemoteUpdate(type).unix > lastDBUpdate(type).unix
    }

    private suspend inline fun <T> request(afterwards: () -> T): T {
        return API.update().let {
            return@let when (it) {
                is APIResult.Success<UpdateResponse> -> {
                    updateData(it.data)
                    afterwards()
                }
                is APIResult.Error -> {
                    when (it) {
                        is APIResult.Error.BackendError -> throw IllegalStateException(it.error)
                        else -> throw FatalException(result = it)
                    }
                }
            }
        }
    }

    private fun updateData(update: UpdateResponse) {
        update.lastUpdates.forEach { lastUpdate ->
            remoteCache[lastUpdate.category] = CacheState(lastUpdate.lastUpdate)
        }
        update.message?.also { m ->
            messageString = m
        }
        recommendedDays = CacheState(update.recommendedDays)
        minVersion = CacheState(update.minVersion)
    }
}
