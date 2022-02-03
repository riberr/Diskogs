package me.riberr.diskogs.endpoints.user.identity

import io.ktor.client.request.*
import me.riberr.diskogs.endpoints.user.Identity
import me.riberr.diskogs.models.response.user.identity.Contributions
import me.riberr.diskogs.util.get

suspend fun Identity.getContributions(
    username: String,
    sort: Contributions.Sort? = null,
    sortOrder: Contributions.SortOrder? = null,
    page: Int? = null,
    perPage: Int? = null
): Result<Contributions> {
    return diskogs.client.get("/users/$username/contributions") {
        if (sort != null) parameter("sort", sort.value)
        if (sortOrder != null) parameter("sort_order", sortOrder.value)
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}

