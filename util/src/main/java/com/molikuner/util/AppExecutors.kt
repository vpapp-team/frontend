package com.molikuner.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


object AppExecutors {
    val diskIO: Executor by lazy { Executors.newSingleThreadExecutor() }
    val networkIO: Executor by lazy { Executors.newFixedThreadPool(3) }
    val mainThread: Executor by lazy { MainThreadExecutor() }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}