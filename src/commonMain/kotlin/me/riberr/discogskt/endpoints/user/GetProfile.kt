package me.riberr.discogskt.endpoints.user

import me.riberr.discogskt.endpoints.User
import me.riberr.discogskt.models.response.user.Profile
import me.riberr.discogskt.util.get

suspend fun User.getProfile(
    username: String
): Result<Profile> {
    return discogsKt.client.get("/users/$username")
}
