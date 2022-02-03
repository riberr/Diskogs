package me.riberr.diskogs.database

import kotlinx.coroutines.launch
import me.riberr.diskogs.Diskogs
import me.riberr.diskogs.endpoints.database
import me.riberr.diskogs.endpoints.database.getRelease
import me.riberr.diskogs.runBlockingTest
import kotlin.test.Test

class ReleaseTest {
    @Test
    fun testGetRelease1() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(249504)
            println(result)
        }
    }

    @Test
    fun testGetRelease2() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(249503)
            println(result)
        }
    }

    @Test
    fun testGetRelease3() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(249502)
            println(result)
        }
    }

    @Test
    fun testGetRelease4() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.database.getRelease(999999)
            println(result)
        }
    }
}