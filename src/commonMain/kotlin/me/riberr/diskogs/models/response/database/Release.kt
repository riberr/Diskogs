package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.response.database.common.*

@Serializable
data class Release(
    val id: Int,
    val status: String,
    val year: Int,
    @SerialName("resource_url")
    val resourceUrl: String,
    val uri: String,
    val artists: List<ArtistLink> = listOf(),
    @SerialName("artists_sort")
    val artistsSort: String,
    val labels: List<Label> = listOf(),
    val series: List<String> = listOf(),
    val companies: List<Company> = listOf(),
    val formats: List<Format> = listOf(),
    @SerialName("data_quality")
    val dataQuality: String,
    val community: Community,
    @SerialName("format_quantity")
    val formatQuantity: Int,
    @SerialName("date_added")
    val dateAdded: String,
    @SerialName("date_changed")
    val dateChanged: String,
    @SerialName("num_for_sale")
    val numForSale: Int,
    @SerialName("lowest_price")
    val lowestPrice: Float?,
    @SerialName("master_id")
    val masterId: Int?,
    @SerialName("master_url")
    val masterUrl: String?,
    val title: String,
    val country: String?,
    val released: String?,
    val notes: String?,
    @SerialName("released_formatted")
    val releasedFormatted: String?,
    val identifiers: List<Identifier> = listOf(),
    val videos: List<Video> = listOf(),
    val genres: List<String> = listOf(),
    val styles: List<String> = listOf(),
    @SerialName("tracklist")
    val trackList: List<Track> = listOf(),
    @SerialName("extraartists")
    val extraArtists: List<ArtistLink> = listOf(),
    val images: List<Image> = listOf(),
    val thumb: String,
    @SerialName("estimated_weight")
    val estimatedWeight: Int?,
    @SerialName("blocked_from_sale")
    val blockedFromSale: Boolean?
) {
    @Serializable
    data class Company(
        val id: Int,
        val name: String,
        @SerialName("catno")
        val catNo: String,
        @SerialName("entity_type")
        val entityType: String,
        @SerialName("entity_type_name")
        val entityTypeName: String,
        @SerialName("resource_url")
        val resourceUrl: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String?,
    )

    @Serializable
    data class Community(
        val have: Int,
        val want: Int,
        val rating: Rating,
        val submitter: User,
        val contributors: List<User> = listOf(),
        @SerialName("data_quality")
        val dataQuality: String,
        val status: String
    )

    @Serializable
    data class Identifier(
        val type: String,
        val value: String,
        val description: String?
    )

    @Serializable
    data class Label(
        val id: Int,
        val name: String,
        @SerialName("catno")
        val catNo: String,
        @SerialName("entity_type")
        val entityType: String,
        @SerialName("entity_type_name")
        val entityTypeName: String,
        @SerialName("resource_url")
        val resourceUrl: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String?,
    )

    @Serializable
    data class User(
        val username: String,
        @SerialName("resource_url")
        val resourceUrl: String
    )
}
