package me.riberr.discogskt.endpoints.database

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.Database
import me.riberr.discogskt.models.response.database.AllLabelReleases
import me.riberr.discogskt.models.response.database.Label
import me.riberr.discogskt.util.get

suspend fun Database.getLabel(labelId: Int): Result<Label> {
    return discogsKt.client.get("/labels/$labelId")
}

suspend fun Database.getLabelReleases(
    labelId: Int,
    page: Int? = null,
    perPage: Int? = null
): Result<AllLabelReleases> {
    return discogsKt.client.get("/labels/$labelId/releases") {
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}