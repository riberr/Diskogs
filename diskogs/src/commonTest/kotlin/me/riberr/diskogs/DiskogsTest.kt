package me.riberr.diskogs

import kotlinx.coroutines.launch
import me.riberr.diskogs.endpoints.database
import me.riberr.diskogs.endpoints.database.getUserRating
import kotlin.test.Test

class DiskogsTest {

    @Test
    fun testGetRating() = runBlockingTest {
        val client = Diskogs.create()
        launch {
            val result = client.database.getUserRating(249504, "memory")
            println(result)
        }
    }
}