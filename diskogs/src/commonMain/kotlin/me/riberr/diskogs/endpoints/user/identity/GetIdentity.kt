package me.riberr.diskogs.endpoints.user.identity


import me.riberr.diskogs.endpoints.user.Identity
import me.riberr.diskogs.util.get

suspend fun Identity.getIdentity(): Result<me.riberr.diskogs.models.response.user.identity.Identity> {
    return diskogs.client.get("/oauth/identity")
}
