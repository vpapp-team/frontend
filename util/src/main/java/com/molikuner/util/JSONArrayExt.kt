package com.molikuner.util

import org.json.JSONArray

@Suppress("UNCHECKED_CAST")
operator fun <T> JSONArray.iterator(): Iterator<T> =
    (0 until length()).asSequence().map { get(it) as T }.iterator()

inline fun <T, R> JSONArray.map(transform: (T) -> R): List<R> =
    this.mapIndexed { _: Int, it: T -> transform(it) }

inline fun <T, R> JSONArray.mapIndexed(transform: (index: Int, T) -> R): List<R> {
    val destination: ArrayList<R> = ArrayList(this.length())
    var index = 0
    for (item in this.iterator<T>()) destination.add(transform(index++, item))
    return destination
}