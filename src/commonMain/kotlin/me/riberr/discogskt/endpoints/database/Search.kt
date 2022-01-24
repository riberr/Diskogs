package me.riberr.discogskt.endpoints.database

import io.ktor.client.request.*
import me.riberr.discogskt.endpoints.Database
import me.riberr.discogskt.models.response.database.Search
import me.riberr.discogskt.util.get

suspend fun Database.search(
    query: String? = null,

    type: Search.Type? = null,
    title: String? = null,
    releaseTitle: String? = null,
    credit: String? = null,
    artist: String? = null,

    anv: String? = null,
    label: String? = null,
    genre: String? = null,
    style: String? = null,
    country: String? = null,

    year: String? = null,
    format: String? = null,
    catNo: String? = null,
    barcode: String? = null,
    track: String? = null,

    submitter: String? = null,
    contributor: String? = null,

    page: Int? = null,
    perPage: Int? = null

): Result<Search> {
    return discogsKt.client.get("/database/search") {
            if (type != null) parameter("query", query)

            if (type != null) parameter("type", type.value)
            if (title != null) parameter("title", title)
            if (releaseTitle != null) parameter("release_title", releaseTitle)
            if (credit != null) parameter("credit", credit)
            if (artist != null) parameter("artist", artist)

            if (anv != null) parameter("anv", anv)
            if (label != null) parameter("label", label)
            if (genre != null) parameter("genre", genre)
            if (style != null) parameter("style", style)
            if (country != null) parameter("country", country)

            if (year != null) parameter("year", year)
            if (format != null) parameter("format", format)
            if (catNo != null) parameter("catno", catNo)
            if (barcode != null) parameter("barcode", barcode)
            if (track != null) parameter("track", track)

            if (submitter != null) parameter("submitter", submitter)
            if (contributor != null) parameter("contributor", contributor)

            if (page != null) parameter("page", page)
            if (perPage != null) parameter("per_page", perPage)
        }
}
