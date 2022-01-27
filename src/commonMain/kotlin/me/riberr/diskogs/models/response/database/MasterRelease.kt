package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.response.database.common.ArtistLink
import me.riberr.diskogs.models.response.database.common.Image
import me.riberr.diskogs.models.response.database.common.Track
import me.riberr.diskogs.models.response.database.common.Video

@Serializable
data class MasterRelease(
    val id: Int,
    val styles: List<String> = listOf(),
    val genres: List<String> = listOf(),
    val videos: List<Video> = listOf(),
    val title: String,
    @SerialName("main_release")
    val mainRelease: Int,
    @SerialName("main_release_url")
    val mainReleaseUrl: String,
    val uri: String,
    val artists: List<ArtistLink> = listOf(),
    @SerialName("versions_url")
    val versionsUrl: String,
    val year: Int,
    val images: List<Image>,
    @SerialName("resource_url")
    val resourceUrl: String,
    @SerialName("tracklist")
    val trackList: List<Track> = listOf(),
    @SerialName("num_for_sale")
    val numForSale: Int,
    @SerialName("lowest_price")
    val lowestPrice: Float?,
    @SerialName("data_quality")
    val dataQuality: String
)