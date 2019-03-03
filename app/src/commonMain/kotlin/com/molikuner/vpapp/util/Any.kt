package com.molikuner.vpapp.util

val <T : Any> T?.unit
    get() = this.let { }

inline fun <T> simpleTry(
    errorMsg: String,
    exception: (String, Throwable) -> Throwable = ::IllegalStateException,
    block: () -> T
): T {
    try {
        return block()
    } catch (e: Exception) {
        throw exception(errorMsg, e)
    }
}
