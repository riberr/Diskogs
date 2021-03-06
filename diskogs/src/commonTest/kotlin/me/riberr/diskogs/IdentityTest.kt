package me.riberr.diskogs

import kotlinx.coroutines.launch
import me.riberr.diskogs.endpoints.user
import me.riberr.diskogs.endpoints.user.identity
import me.riberr.diskogs.endpoints.user.identity.*
import me.riberr.diskogs.models.response.user.identity.Contributions
import kotlin.test.Test

class IdentityTest {

    @Test
    fun testGetProfile() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.user.identity.getProfile("rodneyfool")
            println(result)
        }
    }

    @Test
    fun testGetSubmissions1() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.user.identity.getSubmissions("shooezgirl")
            println(result)
        }
    }

    @Test
    fun testGetSubmissions2() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.user.identity.getSubmissions("mossss", 1, 100)
            println(result)
        }
    }

    @Test
    fun testGetContributions() = runBlockingTest {
        val client = Diskogs.create("FooBarApp/3.0")
        launch {
            val result = client.user.identity.getContributions(
                "mossss",
                sort = Contributions.Sort.ARTIST,
                page = 1,
                perPage = 100
            )
            println(result)
        }
    }
}