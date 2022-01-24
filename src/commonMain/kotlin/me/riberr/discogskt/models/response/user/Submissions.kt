package me.riberr.discogskt.models.response.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.discogskt.models.pagination.Pagination
import me.riberr.discogskt.models.response.database.Release

@Serializable
data class Submissions(
    val pagination: Pagination,
    val submissions: Submission
) {
    @Serializable
    data class Submission(
        val artists: List<SubmissionArtist> = listOf(),
        val labels: List<String> = listOf(),
        val releases: List<Release>
    )

    @Serializable
    data class SubmissionArtist(
        val id: Int,
        val name: String,
        @SerialName("namevariations")
        val nameVariations: List<String> = listOf(),
        @SerialName("data_quality")
        val dataQuality: String,
        @SerialName("releases_url")
        val releasesUrl: String,
        @SerialName("resource_url")
        val resourceUrl: String,
        val uri: String,
        val profile: String
    )
}