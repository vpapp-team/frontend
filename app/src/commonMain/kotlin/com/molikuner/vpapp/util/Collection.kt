package com.molikuner.vpapp.util

inline fun <T, R> Collection<T>.associateWithIndexed(valueSelector: (Int, T) -> R): Map<T, R> {
    val destination = LinkedHashMap<T, R>(size)
    this.forEachIndexed { index, item ->
        destination[item] = valueSelector(index, item)
    }

    return destination
}
