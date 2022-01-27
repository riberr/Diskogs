package me.riberr.diskogs.models.request.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PutRating(
    val username: String,
    @SerialName("release_id")
    val releaseId: Int,
    val rating: Int
)