package me.riberr.discogskt.endpoints.user.identity


import me.riberr.discogskt.endpoints.user.Identity
import me.riberr.discogskt.util.get

suspend fun Identity.getIdentity(): Result<me.riberr.discogskt.models.response.user.identity.Identity> {
    return discogsKt.client.get("/oauth/identity")
}
