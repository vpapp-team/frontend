package com.molikuner.nigb

import android.app.Application
import com.molikuner.nigb.db.AppDatabase

class BasicApp : Application() {
    private var mAppExecutors: AppExecutors? = null

    override fun onCreate() {
        super.onCreate()

        mAppExecutors = AppExecutors()
    }

    fun getDatabase(): AppDatabase {
        // this will be called after the onCreate
        return AppDatabase.getInstance(this, mAppExecutors!!)
    }

    fun getRepository(): DataRepository {
        return DataRepository.getInstance(getDatabase())
    }
}