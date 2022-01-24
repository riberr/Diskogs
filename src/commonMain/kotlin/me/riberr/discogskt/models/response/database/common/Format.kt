package me.riberr.discogskt.models.response.database.common

import kotlinx.serialization.Serializable

@Serializable
data class Format(
    val name: String,
    val qty: String,
    val text: String?,
    val descriptions: List<String> = listOf()
)