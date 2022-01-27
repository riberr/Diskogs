package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.response.database.common.Image

@Serializable
data class Artist(
    val id: Int,
    @SerialName("namevariations")
    val nameVariations: List<String> = listOf(),
    val profile: String,
    @SerialName("releases_url")
    val releasesUrl: String,
    @SerialName("resource_url")
    val resourceUrl: String,
    val uri: String,
    val urls: List<String> = listOf(),
    @SerialName("data_quality")
    val dataQuality: String,
    val images: List<Image> = listOf(),
    val members: List<Member> = listOf(),
    val name: String?,
    @SerialName("realname")
    val realName: String?,
    val aliases: List<Alias> = listOf()
) {
    @Serializable
    data class Member(
        val id: Int,
        val active: Boolean,
        val name: String,
        @SerialName("resource_url")
        val resourceUrl: String
    )

    @Serializable
    data class Alias(
        val id: Int,
        val name: String,
        @SerialName("resource_url")
        val resourceUrl: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String
    )
}