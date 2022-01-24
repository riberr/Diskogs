package me.riberr.discogskt.models.pagination

import kotlinx.serialization.Serializable

@Serializable
data class Urls(
    val first: String?,
    val prev: String?,
    val next: String?,
    val last: String?
)