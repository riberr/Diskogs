package me.riberr.discogskt.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.discogskt.models.response.database.common.Rating

@Serializable
data class CommunityRating(
    @SerialName("release_id")
    val releaseId: Int,
    val rating: Rating
)