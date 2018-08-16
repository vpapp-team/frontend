package com.molikuner.nigb

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.molikuner.nigb.db.AppDatabase
import com.molikuner.nigb.db.entity.StandInEntity

class DataRepository private constructor(private val mDatabase: AppDatabase) {
    private val mObservableProducts: MediatorLiveData<List<StandInEntity>> = MediatorLiveData()

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    val products: LiveData<List<StandInEntity>>
        get() = mObservableProducts

    init {

        mObservableProducts.addSource(
            mDatabase.standInDao().loadAll()
        ) { productEntities ->
            if (mDatabase.databaseCreated.value != null) {
                mObservableProducts.postValue(productEntities)
            }
        }
    }

//    fun loadProduct(productId: Int): LiveData<StandInEntity> {
//        return mDatabase.standInDao().loadProduct(productId)
//    }
//
//    fun loadComments(productId: Int): LiveData<List<CommentEntity>> {
//        return mDatabase.commentDao().loadComments(productId)
//    }

    companion object {

        private var sInstance: DataRepository? = null

        fun getInstance(database: AppDatabase): DataRepository {
            if (sInstance == null) {
                synchronized(DataRepository::class.java) {
                    if (sInstance == null) {
                        sInstance = DataRepository(database)
                    }
                }
            }
            return sInstance!!
        }
    }
}