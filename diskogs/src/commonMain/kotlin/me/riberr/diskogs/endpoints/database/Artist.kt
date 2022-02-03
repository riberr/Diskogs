package me.riberr.diskogs.endpoints.database

import io.ktor.client.request.*
import me.riberr.diskogs.endpoints.Database
import me.riberr.diskogs.models.response.database.Artist
import me.riberr.diskogs.models.response.database.ArtistReleases
import me.riberr.diskogs.util.get

/*
    val response: HttpResponse = client.get(url)
    val myObject: MyObject = response.receive<MyObject>()
 */

suspend fun Database.getArtist(artistId: Int): Result<Artist> {
    return diskogs.client.get("/artists/$artistId")
}

suspend fun Database.getArtistReleases(
    artistId: Int,
    sort: ArtistReleases.Sort? = null,
    sortOrder: ArtistReleases.SortOrder? = null,
    page: Int? = null,
    perPage: Int? = null
): Result<ArtistReleases> {
    return diskogs.client.get("/artists/$artistId/releases") {
        if (sort != null) parameter("sort", sort.value)
        if (sortOrder != null) parameter("sort_order", sortOrder.value)
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}