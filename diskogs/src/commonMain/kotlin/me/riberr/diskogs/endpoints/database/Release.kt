package me.riberr.diskogs.endpoints.database

import me.riberr.diskogs.endpoints.Database
import me.riberr.diskogs.models.response.database.Release
import me.riberr.diskogs.models.response.database.ReleaseStats
import me.riberr.diskogs.util.get

suspend fun Database.getRelease(
    releaseId: Int
): Result<Release> {
    return diskogs.client.get("/releases/$releaseId")
}

suspend fun Database.getReleaseStats(
    releaseId: Int
): Result<ReleaseStats> {
    return diskogs.client.get("/releases/$releaseId/stats")
}