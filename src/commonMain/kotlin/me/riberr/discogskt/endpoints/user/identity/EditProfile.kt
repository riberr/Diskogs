package me.riberr.discogskt.endpoints.user.identity

import io.ktor.http.*
import me.riberr.discogskt.endpoints.user.Identity
import me.riberr.discogskt.models.request.user.identity.PostProfile
import me.riberr.discogskt.models.response.user.identity.Profile
import me.riberr.discogskt.util.post

suspend fun Identity.postProfile(
    username: String,
    name: String? = null,
    homePage: String? = null,
    location: String? = null,
    profile: String? = null,
    currAbbr: String? = null
): Result<Profile> {
    return discogsKt.client.post("/users/$username") {
        contentType(ContentType.Application.Json)
        body = PostProfile(username, name, homePage, location, profile, currAbbr)
    }
}

