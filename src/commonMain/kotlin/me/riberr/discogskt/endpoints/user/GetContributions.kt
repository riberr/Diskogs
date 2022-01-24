package me.riberr.discogskt.endpoints.user

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.User
import me.riberr.discogskt.models.response.user.Contributions
import me.riberr.discogskt.util.get

suspend fun User.getContributions(
    username: String,
    sort: Contributions.Sort? = null,
    sortOrder: Contributions.SortOrder? = null,
    page: Int? = null,
    perPage: Int? = null
): Result<Contributions> {
    return discogsKt.client.get("/users/$username/contributions") {
        if (sort != null) parameter("sort", sort.value)
        if (sortOrder != null) parameter("sort_order", sortOrder.value)
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}

