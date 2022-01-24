package me.riberr.discogskt.models.response.database.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistLink(
    val id: Int,
    val name: String,
    val anv: String,
    val join: String,
    val role: String,
    val tracks: String,
    @SerialName("resource_url")
    val resourceUrl: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String?
)