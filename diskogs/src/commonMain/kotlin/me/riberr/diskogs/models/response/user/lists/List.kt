package me.riberr.diskogs.models.response.user.lists

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.List

@Serializable
data class List(
    @SerialName("created_ts")
    val created_ts: String,
    @SerialName("modified_ts")
    val modified_ts: String,
    val name: String,
    @SerialName("list_id")
    val list_id: Int,
    val url: String,
    val resource_url: String,
    val public: Boolean,
    val description: String,
    val items: List<Item> = listOf()
) {
    @Serializable
    data class Item(
        val id: Int,
        val comment: String,
        @SerialName("display_title")
        val displayTitle: String,
        val uri: String,
        @SerialName("image_url")
        val imageUrl: String,
        @SerialName("resource_url")
        val resourceUrl: String,
        val type: String
    )
}