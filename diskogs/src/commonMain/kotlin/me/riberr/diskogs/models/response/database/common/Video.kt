package me.riberr.diskogs.models.response.database.common

import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val uri: String,
    val title: String,
    val description: String,
    val duration: Int,
    val embed: Boolean
)