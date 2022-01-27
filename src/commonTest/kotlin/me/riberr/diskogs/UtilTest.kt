package me.riberr.diskogs

import me.riberr.diskogs.util.epochMillis
import kotlin.test.Test

class UtilTest {
    @Test
    fun testGetProfile() = runBlockingTest {
        val myTime = epochMillis()
        println(myTime)
    }
}