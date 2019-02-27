package com.molikuner.vpapp.util

import kotlinx.coroutines.CoroutineScope

actual fun <T : Any> runBlocking(block: suspend CoroutineScope.() -> T): T = kotlinx.coroutines.runBlocking(block = block)
