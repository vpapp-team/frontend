package com.molikuner.vpapp.util

import kotlin.jvm.Synchronized

class Singleton<T: Any>(private val saveInit: Boolean = true) {
    private lateinit var x: T

    @Synchronized
    fun getValue(init: () -> T = { throw IllegalStateException("Value isn't initialized") }): T {
        if (!::x.isInitialized) x = init()
        return x
    }

    fun setValue(nX: T) {
        if (!::x.isInitialized || !saveInit || throw IllegalStateException("Value is already initialized")) x = nX
    }
}
