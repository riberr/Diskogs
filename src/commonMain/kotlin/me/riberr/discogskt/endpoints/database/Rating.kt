package me.riberr.discogskt.endpoints.database

import io.ktor.http.*
import me.riberr.discogskt.endpoints.Database
import me.riberr.discogskt.models.request.database.PutRating
import me.riberr.discogskt.models.response.database.CommunityRating
import me.riberr.discogskt.models.response.database.UserRating
import me.riberr.discogskt.util.delete
import me.riberr.discogskt.util.get
import me.riberr.discogskt.util.put

suspend fun Database.getUserRating(
    releaseId: Int,
    username: String
): Result<UserRating> {
    return discogsKt.client.get("/releases/$releaseId/rating/$username")
}

suspend fun Database.putUserRating(
    releaseId: Int,
    username: String,
    rating: Int
): Result<UserRating> {
    val r = if (rating > 5) 5 else if (rating < 1) 1 else rating
    val b = PutRating(username, releaseId, r)
    return discogsKt.client.put("/releases/$releaseId/rating/$username") {
        contentType(ContentType.Application.Json)
        body = b
    }
}

suspend fun Database .deleteUserRating(
    releaseId: Int,
    username: String
): Result<Unit> {
    return discogsKt.client.delete("/releases/$releaseId/rating/$username")
}

suspend fun Database.getCommunityRating(releaseId: Int): Result<CommunityRating> {
    return discogsKt.client.get("/releases/$releaseId/rating")
}