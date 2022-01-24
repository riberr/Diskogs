package me.riberr.discogskt.database

import kotlinx.coroutines.launch
import me.riberr.discogskt.DiscogsKt
import me.riberr.discogskt.endpoints.database
import me.riberr.discogskt.endpoints.database.getRelease
import me.riberr.discogskt.runBlockingTest
import kotlin.test.Test

class ReleaseTest {
    @Test
    fun testGetRelease1() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(249504)
            println(result)
        }
    }

    @Test
    fun testGetRelease2() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(249503)
            println(result)
        }
    }

    @Test
    fun testGetRelease3() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(249502)
            println(result)
        }
    }

    @Test
    fun testGetRelease4() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(999999)
            println(result)
        }
    }
}