package me.riberr.discogskt.database

import kotlinx.coroutines.launch
import me.riberr.discogskt.DiscogsKt
import me.riberr.discogskt.endpoints.database
import me.riberr.discogskt.endpoints.database.search
import me.riberr.discogskt.models.response.database.Search
import me.riberr.discogskt.runBlockingTest
import kotlin.test.Test

class SearchTest {
    @Test
    fun testSearch1() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.database.search(
                releaseTitle = "nevermind",
                artist = "nirvana",
                perPage = 3,
                page = 1
            )
            println(result)
        }
    }

    @Test
    fun testSearch2() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.database.search(
                artist = "burzum",
                perPage = 20,
                page = 1
            )
            println(result)
        }
    }

    @Test
    fun testSearch3() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.database.search(
                type = Search.Type.RELEASE,
                label = "Nuclear Blast",
                perPage = 20,
                page = 1
            )
            println(result)
        }
    }

    @Test
    fun testSearch4() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.database.search(
                query = "extrawelt",
                perPage = 20,
                page = 1
            )
            println(result)
        }
    }

    @Test
    fun testSearch5() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.database.search(
                query = "brulvahnatu",
                perPage = 50,
                page = 1
            )
            println(result)
        }
    }
}