package me.riberr.discogskt.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.discogskt.models.pagination.Pagination
import me.riberr.discogskt.models.response.database.common.Stats

@Serializable
data class ArtistReleases(
    //val id: Int,
    val releases: List<ArtistRelease> = listOf(),
    val pagination: Pagination
) {

    @Serializable
    data class ArtistRelease(
        val id: Int,
        val artist: String,
        @SerialName("main_release")
        val main_release: Int?,
        @SerialName("resource_url")
        val resource_url: String,
        val role: String,
        val thumb: String,
        val title: String,
        val type: String,
        val year: Int,
        val status: String?,
        val format: String?,
        val release: String?,
        val label: String?,
        val stats: Stats
    )

    enum class Sort(val value: String) {
        YEAR("year"),
        TITLE("title"),
        FORMAT("format")
    }

    enum class SortOrder(val value: String) {
        ASC("asc"),
        DESC("desc"),
    }
}