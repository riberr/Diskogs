package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReleaseStats(
    @SerialName("num_have")
    val numHave: Int?,
    @SerialName("num_want")
    val numWant: Int?,
    @SerialName("is_offensive")
    val isOffensive: Boolean?
)
