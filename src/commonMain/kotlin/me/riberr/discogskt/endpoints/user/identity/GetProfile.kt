package me.riberr.discogskt.endpoints.user.identity

import me.riberr.discogskt.endpoints.user.Identity
import me.riberr.discogskt.models.response.user.identity.Profile
import me.riberr.discogskt.util.get

suspend fun Identity.getProfile(
    username: String
): Result<Profile> {
    return discogsKt.client.get("/users/$username")
}
