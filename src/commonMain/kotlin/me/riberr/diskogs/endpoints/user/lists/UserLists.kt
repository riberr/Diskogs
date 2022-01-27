package me.riberr.diskogs.endpoints.user.lists

import me.riberr.diskogs.endpoints.user.Lists
import me.riberr.diskogs.models.response.user.lists.UserLists
import me.riberr.diskogs.util.get

suspend fun Lists.getUserLists(username: String): Result<UserLists> {
    return diskogs.client.get("/users/$username/lists")
}