package me.riberr.discogskt.models.pagination

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    val page: Int,
    val pages: Int,
    val items: Int,
    @SerialName("per_page")
    val perPage: Int,
    val urls: Urls
)

