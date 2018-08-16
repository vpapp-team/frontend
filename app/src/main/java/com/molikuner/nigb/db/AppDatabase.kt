package com.molikuner.nigb.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.support.annotation.VisibleForTesting
import com.molikuner.nigb.AppExecutors
import com.molikuner.nigb.db.dao.CalendarEventDao
import com.molikuner.nigb.db.dao.LastUpdateDao
import com.molikuner.nigb.db.dao.MOTDDao
import com.molikuner.nigb.db.dao.StandInDao
import com.molikuner.nigb.db.entity.CalendarEventEntity
import com.molikuner.nigb.db.entity.LastUpdateEntity
import com.molikuner.nigb.db.entity.MOTDEntity
import com.molikuner.nigb.db.entity.StandInEntity


@Database(
    entities = [CalendarEventEntity::class, LastUpdateEntity::class, MOTDEntity::class, StandInEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    private val mIsDatabaseCreated = MutableLiveData<Boolean>()

    val databaseCreated: LiveData<Boolean>
        get() = mIsDatabaseCreated

    abstract fun calendarDao(): CalendarEventDao

    abstract fun lastUpdateDao(): LastUpdateDao

    abstract fun motdDao(): MOTDDao

    abstract fun standInDao(): StandInDao

    /**
     * Check whether the database already exists and expose it via [.getDatabaseCreated]
     */
    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated()
        }
    }

    private fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }

    companion object {
        private var sInstance: AppDatabase? = null

        @VisibleForTesting
        val DATABASE_NAME = "NIGB"

        fun getInstance(context: Context, executors: AppExecutors): AppDatabase {
            if (sInstance == null) {
                synchronized(AppDatabase::class.java) {
                    if (sInstance == null) {
                        sInstance = buildDatabase(context.applicationContext, executors)
                        sInstance!!.updateDatabaseCreated(context.applicationContext)
                    }
                }
            }
            return sInstance!!
        }

        /**
         * Build the database. [Builder.build] only sets up the database configuration and
         * creates a new instance of the database.
         * The SQLite database is only created when it's accessed for the first time.
         */
        private fun buildDatabase(
            appContext: Context,
            executors: AppExecutors
        ): AppDatabase {
            return Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        executors.diskIO().execute {
                            // TODO request data
                            // Add a delay to simulate a long-running operation
                            addDelay()
                            // Generate the data for pre-population
                            val database = AppDatabase.getInstance(appContext, executors)

                            //insertData(database, products, comments)
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated()
                        }
                    }
                }).build()
        }

//        private fun insertData(
//            database: AppDatabase, products: List<ProductEntity>,
//            comments: List<CommentEntity>
//        ) {
//            database.runInTransaction {
//                database.productDao().insertAll(products)
//                database.commentDao().insertAll(comments)
//            }
//        }

        private fun addDelay() {
            try {
                Thread.sleep(4000)
            } catch (ignored: InterruptedException) {
            }

        }
    }
}