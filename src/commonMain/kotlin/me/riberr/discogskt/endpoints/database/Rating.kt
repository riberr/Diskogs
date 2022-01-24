package me.riberr.discogskt.endpoints.database

import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.*
import me.riberr.discogskt.endpoints.Database
import me.riberr.discogskt.models.response.database.CommunityRating
import me.riberr.discogskt.models.response.database.UserRating
import me.riberr.discogskt.util.get
import me.riberr.discogskt.util.put

suspend fun Database.getUserRating(
    releaseId: Int,
    username: String
): Result<UserRating> {
    return discogsKt.client.get("/releases/$releaseId/rating/$username")
}

private fun fixRating(rating: Int): Int = if (rating > 5) 5 else if (rating < 1) 1 else rating

suspend fun Database.putUserRating(
    releaseId: Int,
    username: String,
    rating: Int
): Result<UserRating> {
    val b = "{ \"rating\": ${fixRating(rating)} }"
    return discogsKt.client.put("/releases/$releaseId/rating/$username") {
        contentType(ContentType.Application.Json)
        body = b
    }
}

suspend fun Database.getCommunityRating(releaseId: Int): Result<CommunityRating> {
    return discogsKt.client.get("/releases/$releaseId/rating")
}