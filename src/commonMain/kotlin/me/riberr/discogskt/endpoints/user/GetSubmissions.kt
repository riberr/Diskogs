package me.riberr.discogskt.endpoints.user

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.User
import me.riberr.discogskt.models.response.user.Submissions
import me.riberr.discogskt.util.get

suspend fun User.getSubmissions(
    username: String,
    page: Int? = null,
    perPage: Int? = null
): Result<Submissions> {
    return discogsKt.client.get("/users/$username/submissions") {
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}

