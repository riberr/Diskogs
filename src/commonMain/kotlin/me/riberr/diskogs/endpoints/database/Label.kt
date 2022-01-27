package me.riberr.diskogs.endpoints.database

import io.ktor.client.request.*
import me.riberr.diskogs.endpoints.Database
import me.riberr.diskogs.models.response.database.AllLabelReleases
import me.riberr.diskogs.models.response.database.Label
import me.riberr.diskogs.util.get

suspend fun Database.getLabel(labelId: Int): Result<Label> {
    return diskogs.client.get("/labels/$labelId")
}

suspend fun Database.getLabelReleases(
    labelId: Int,
    page: Int? = null,
    perPage: Int? = null
): Result<AllLabelReleases> {
    return diskogs.client.get("/labels/$labelId/releases") {
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}