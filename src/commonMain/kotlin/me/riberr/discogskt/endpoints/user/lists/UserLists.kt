package me.riberr.discogskt.endpoints.user.lists

import me.riberr.discogskt.endpoints.user.Lists
import me.riberr.discogskt.models.response.user.lists.UserLists
import me.riberr.discogskt.util.get

suspend fun Lists.getUserLists(username: String): Result<UserLists> {
    return discogsKt.client.get("/users/$username/lists")
}