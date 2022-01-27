package me.riberr.diskogs.endpoints.user.lists

import me.riberr.diskogs.endpoints.user.Lists
import me.riberr.diskogs.util.get

suspend fun Lists.getList(listId: Int): Result<me.riberr.diskogs.models.response.user.lists.List> {
    return diskogs.client.get("/lists/$listId")
}

