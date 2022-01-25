package me.riberr.discogskt.endpoints.user.lists

import me.riberr.discogskt.endpoints.user.Lists
import me.riberr.discogskt.util.get

suspend fun Lists.getList(listId: Int): Result<me.riberr.discogskt.models.response.user.lists.List> {
    return discogsKt.client.get("/lists/$listId")
}

