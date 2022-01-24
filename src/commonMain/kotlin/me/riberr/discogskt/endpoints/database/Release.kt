package me.riberr.discogskt.endpoints.database

import me.riberr.discogskt.endpoints.Database
import me.riberr.discogskt.models.response.database.Release
import me.riberr.discogskt.models.response.database.ReleaseStats
import me.riberr.discogskt.util.get

suspend fun Database.getRelease(
    releaseId: Int
): Result<Release> {
    return discogsKt.client.get("/releases/$releaseId")
}

suspend fun Database.getReleaseStats(
    releaseId: Int
): Result<ReleaseStats> {
    return discogsKt.client.get("/releases/$releaseId/stats")
}