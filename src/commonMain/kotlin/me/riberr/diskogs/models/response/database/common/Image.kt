package me.riberr.diskogs.models.response.database.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val type: String,
    val uri: String,
    @SerialName("resource_url")
    val resourceUrl: String,
    val uri150: String,
    val width: Int,
    val height: Int
)