package me.riberr.diskogs.endpoints.user.identity

import me.riberr.diskogs.endpoints.user.Identity
import me.riberr.diskogs.models.response.user.identity.Profile
import me.riberr.diskogs.util.get

suspend fun Identity.getProfile(
    username: String
): Result<Profile> {
    return diskogs.client.get("/users/$username")
}
