package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.pagination.Pagination
import me.riberr.diskogs.models.response.database.common.Stats

@Serializable
data class MasterReleaseVersions(
    val versions: List<MasterVersion> = listOf(),
    val pagination: Pagination
) {
    @Serializable
    data class MasterVersion(
        val id: Int,
        val status: String,
        val stats: Stats,
        val thumb: String,
        val format: String?,
        val country: String?,
        val title: String,
        val label: String?,
        val released: String?,
        @SerialName("major_formats")
        val majorFormats: List<String> = listOf(),
        @SerialName("catno")
        val catNo: String,
        @SerialName("resource_url")
        val resourceUrl: String
    )

    // todo: place somewhere else? This is the response, not the request
    enum class Sort(val value: String) {
        RELEASED("released"),
        TITLE("title"),
        FORMAT("format"),
        LABEL("label"),
        CATNO("catno"),
        COUNTRY("country")
    }

    enum class SortOrder(val value: String) {
        ASC("asc"),
        DESC("desc")
    }
}