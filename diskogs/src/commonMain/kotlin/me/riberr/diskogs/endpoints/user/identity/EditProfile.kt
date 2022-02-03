package me.riberr.diskogs.endpoints.user.identity

import io.ktor.http.*
import me.riberr.diskogs.endpoints.user.Identity
import me.riberr.diskogs.models.request.user.identity.PostProfile
import me.riberr.diskogs.models.response.user.identity.Profile
import me.riberr.diskogs.util.post

suspend fun Identity.postProfile(
    username: String,
    name: String? = null,
    homePage: String? = null,
    location: String? = null,
    profile: String? = null,
    currAbbr: String? = null
): Result<Profile> {
    return diskogs.client.post("/users/$username") {
        contentType(ContentType.Application.Json)
        body = PostProfile(username, name, homePage, location, profile, currAbbr)
    }
}

