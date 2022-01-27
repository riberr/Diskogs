package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.pagination.Pagination
import me.riberr.diskogs.models.response.database.common.Stats

@Serializable
data class AllLabelReleases(
    val releases: List<ReleaseLink> = listOf(),
    val pagination: Pagination
) {
    @Serializable
    data class ReleaseLink(
        val id: Int,
        val artist: String,
        @SerialName("catno")
        val catNo: String,
        val format: String,
        @SerialName("resource_url")
        val resource_url: String,
        val status: String,
        val thumb: String,
        val title: String,
        val year: Int,
        val stats: Stats
    )
}