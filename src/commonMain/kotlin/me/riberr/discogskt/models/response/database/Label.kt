package me.riberr.discogskt.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.discogskt.models.response.database.common.Image

@Serializable
data class Label(
    val id: Int,
    val name: String,
    val profile: String,
    @SerialName("releases_url")
    val releasesUrl: String,
    @SerialName("contact_info")
    val contactInfo: String,
    val uri: String,
    @SerialName("sublabels")
    val subLabels: List<LabelLink> = listOf(),
    val urls: List<String> = listOf(),
    val images: List<Image> = listOf(),
    @SerialName("resource_url")
    val resource_url: String,
    @SerialName("data_quality")
    val data_quality: String,
    @SerialName("parent_label")
    val parentLabel: LabelLink
) {

    @Serializable
    data class LabelLink(
        val id: Int,
        val name: String,
        @SerialName("resource_url")
        val resource_url: String
    )
}