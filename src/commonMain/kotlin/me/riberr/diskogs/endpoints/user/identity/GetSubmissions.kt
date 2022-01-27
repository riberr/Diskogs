package me.riberr.diskogs.endpoints.user.identity

import io.ktor.client.request.*
import me.riberr.diskogs.endpoints.user.Identity
import me.riberr.diskogs.models.response.user.identity.Submissions
import me.riberr.diskogs.util.get

suspend fun Identity.getSubmissions(
    username: String,
    page: Int? = null,
    perPage: Int? = null
): Result<Submissions> {
    return diskogs.client.get("/users/$username/submissions") {
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}

