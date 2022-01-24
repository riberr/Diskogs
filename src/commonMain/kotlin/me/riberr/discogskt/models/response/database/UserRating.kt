package me.riberr.discogskt.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRating(
    val username: String,
    @SerialName("release_id")
    val releaseId: Int,
    val rating: Int
)