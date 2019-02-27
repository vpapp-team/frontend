package com.molikuner.vpapp

import com.molikuner.vpapp.platform.Platform

fun hello(): String = "Hello from ${Platform.PLATFORM}"

fun main() {
    println(hello())
}
