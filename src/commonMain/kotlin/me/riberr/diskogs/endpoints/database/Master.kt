package me.riberr.diskogs.endpoints.database

import io.ktor.client.request.*
import me.riberr.diskogs.endpoints.Database
import me.riberr.diskogs.models.response.database.MasterReleaseVersions
import me.riberr.diskogs.models.response.database.MasterRelease
import me.riberr.diskogs.util.get

suspend fun Database.getMasterRelease(
    masterId: Int
): Result<MasterRelease> {
    return diskogs.client.get("/masters/$masterId")
}

suspend fun Database.getMasterReleaseVersions(
    masterId: Int,
    format: String? = null,
    label: String? = null,
    released: String? = null,
    country: String? = null,
    sort: MasterReleaseVersions.Sort? = null,
    sortOrder: MasterReleaseVersions.SortOrder? = null,
    page: Int? = null,
    perPage: Int? = null
): Result<MasterReleaseVersions> {

    return diskogs.client.get("/masters/$masterId/versions") {
        if (format != null) parameter("format", format)
        if (label != null) parameter("label", label)
        if (released != null) parameter("released", released)
        if (country != null) parameter("country", country)

        if (sort != null) parameter("sort", sort.value)
        if (sortOrder != null) parameter("sort_order", sortOrder.value)
        if (page != null) parameter("page", page)
        if (perPage != null) parameter("per_page", perPage)
    }
}
