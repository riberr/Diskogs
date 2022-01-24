package me.riberr.discogskt.endpoints.user

import io.ktor.http.*
import me.riberr.discogskt.endpoints.User
import me.riberr.discogskt.models.request.user.EditProfileReq
import me.riberr.discogskt.models.response.user.Profile
import me.riberr.discogskt.util.post

suspend fun User.editProfile(
    username: String,
    name: String? = null,
    homePage: String? = null,
    location: String? = null,
    profile: String? = null,
    currAbbr: String? = null
): Result<Profile> {
    return discogsKt.client.post("/users/$username") {
        contentType(ContentType.Application.Json)
        body = EditProfileReq(username, name, homePage, location, profile, currAbbr)
    }
}

