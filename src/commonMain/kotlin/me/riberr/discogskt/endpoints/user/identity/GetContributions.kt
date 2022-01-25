package me.riberr.discogskt.endpoints.user.identity

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.user.Identity
import me.riberr.discogskt.models.response.user.identity.Contributions
import me.riberr.discogskt.util.get

suspend fun Identity.getContributions(
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

