package com.molikuner.vpapp.util

import kotlinx.coroutines.CoroutineScope

expect fun <T : Any> runBlocking(block: suspend CoroutineScope.() -> T): T
