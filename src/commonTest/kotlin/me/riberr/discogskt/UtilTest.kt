package me.riberr.discogskt

import me.riberr.discogskt.util.epochMillis
import kotlin.test.Test

class UtilTest {
    @Test
    fun testGetProfile() = runBlockingTest {
        val myTime = epochMillis()
        println(myTime)
    }
}