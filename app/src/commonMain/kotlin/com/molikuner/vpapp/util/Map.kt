package com.molikuner.vpapp.util

fun <K, V> Map<K, V>.getOrNull(key: K): V? {
    return this.getOrElse(key) { null }
}
