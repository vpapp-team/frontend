package com.molikuner.vpapp

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTests {
    @Test
    fun testMe() {
        assertTrue(1 > 0)
    }

    @Test
    fun testProxy() {
        assertTrue(hello().isNotEmpty())
    }
}