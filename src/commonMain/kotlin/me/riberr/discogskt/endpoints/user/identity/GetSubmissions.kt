package me.riberr.discogskt.endpoints.user.identity

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.user.Identity
import me.riberr.discogskt.models.response.user.identity.Submissions
import me.riberr.discogskt.util.get

suspend fun Identity.getSubmissions(
    username: String,
    page: Int? = null,
    perPage: Int? = null
): Result<Submissions> {
    return discogsKt.client.get("/users/$username/submissions") {
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}

