package com.molikuner.vpapp.data.repository

abstract class BaseRepository<T : Any> {
    internal abstract suspend fun saveData(l: List<T>)
    internal abstract suspend fun getData(): List<T>
}