package me.riberr.discogskt

import kotlinx.coroutines.launch
import me.riberr.discogskt.endpoints.user
import me.riberr.discogskt.endpoints.user.*
import me.riberr.discogskt.models.pagination.PaginationReq
import me.riberr.discogskt.models.response.user.Contributions
import kotlin.test.Test

class UserTest {
    @Test
    fun testGetProfileWithAuth() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.user.getProfile("ittakkva")
            println(result)
        }
    }

    @Test
    fun testGetProfile() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.user.getProfile("rodneyfool")
            println(result)
        }
    }

    @Test
    fun testEditProfile() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.user.editProfile("ittakkva", location = "Sweden")
            println(result)
        }
    }

    @Test
    fun testGetIdentity() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.user.getIdentity()
            println(result)
        }
    }

    @Test
    fun testGetSubmissions1() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.user.getSubmissions("shooezgirl")
            println(result)
        }
    }

    @Test
    fun testGetSubmissions2() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.user.getSubmissions("mossss", 1, 100)
            println(result)
        }
    }

    @Test
    fun testGetContributions() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.user.getContributions(
                "mossss",
                sort = Contributions.Sort.ARTIST,
                page = 1,
                perPage = 100
            )
            println(result)
        }
    }
}