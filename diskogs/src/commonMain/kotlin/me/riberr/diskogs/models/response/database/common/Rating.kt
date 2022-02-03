package me.riberr.diskogs.models.response.database.common

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val count: Int,
    val average: Float
)