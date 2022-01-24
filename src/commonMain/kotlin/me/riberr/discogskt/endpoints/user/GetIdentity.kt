package me.riberr.discogskt.endpoints.user

import me.riberr.discogskt.endpoints.User
import me.riberr.discogskt.models.response.user.Identity
import me.riberr.discogskt.util.get

suspend fun User.getIdentity(): Result<Identity> {
    return discogsKt.client.get("/oauth/identity")
}
