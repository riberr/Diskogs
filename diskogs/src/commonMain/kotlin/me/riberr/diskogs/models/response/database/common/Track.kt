package me.riberr.diskogs.models.response.database.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
    val position: String,
    @SerialName("type_")
    val type: String,
    val title: String,
    val duration: String,
    val artists: List<ArtistLink> = listOf(),
    @SerialName("extraartists")
    val extraArtists: List<ArtistLink> = listOf()
)