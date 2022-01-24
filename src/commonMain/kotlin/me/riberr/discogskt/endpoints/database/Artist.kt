package me.riberr.discogskt.endpoints.database

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.Database
import me.riberr.discogskt.models.response.database.Artist
import me.riberr.discogskt.models.response.database.ArtistReleases
import me.riberr.discogskt.util.get

suspend fun Database.getArtist(artistId: Int): Result<Artist> {
    return discogsKt.client.get("/artists/$artistId")
}

suspend fun Database.getArtistReleases(
    artistId: Int,
    sort: ArtistReleases.Sort? = null,
    sortOrder: ArtistReleases.SortOrder? = null,
    page: Int? = null,
    perPage: Int? = null
): Result<ArtistReleases> {
    return discogsKt.client.get("/artists/$artistId/releases") {
        if (sort != null) parameter("sort", sort.value)
        if (sortOrder != null) parameter("sort_order", sortOrder.value)
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}