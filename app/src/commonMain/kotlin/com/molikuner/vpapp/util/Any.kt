package com.molikuner.vpapp.util

val <T : Any> T?.unit
    get() = this.let { }

inline fun <T> simpleTry(errorMsg: String, block: () -> T): T {
    try {
        return block()
    } catch (e: Exception) {
        throw IllegalStateException(errorMsg, e)
    }
}
