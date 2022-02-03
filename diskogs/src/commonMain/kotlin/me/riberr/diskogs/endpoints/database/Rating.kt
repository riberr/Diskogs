package me.riberr.diskogs.endpoints.database

import io.ktor.http.*
import me.riberr.diskogs.endpoints.Database
import me.riberr.diskogs.models.request.database.PutRating
import me.riberr.diskogs.models.response.database.CommunityRating
import me.riberr.diskogs.models.response.database.UserRating
import me.riberr.diskogs.util.delete
import me.riberr.diskogs.util.get
import me.riberr.diskogs.util.put

suspend fun Database.getUserRating(
    releaseId: Int,
    username: String
): Result<UserRating> {
    return diskogs.client.get("/releases/$releaseId/rating/$username")
}

suspend fun Database.putUserRating(
    releaseId: Int,
    username: String,
    rating: Int
): Result<UserRating> {
    val r = if (rating > 5) 5 else if (rating < 1) 1 else rating
    val b = PutRating(username, releaseId, r)
    return diskogs.client.put("/releases/$releaseId/rating/$username") {
        contentType(ContentType.Application.Json)
        body = b
    }
}

suspend fun Database .deleteUserRating(
    releaseId: Int,
    username: String
): Result<Unit> {
    return diskogs.client.delete("/releases/$releaseId/rating/$username")
}

suspend fun Database.getCommunityRating(releaseId: Int): Result<CommunityRating> {
    return diskogs.client.get("/releases/$releaseId/rating")
}