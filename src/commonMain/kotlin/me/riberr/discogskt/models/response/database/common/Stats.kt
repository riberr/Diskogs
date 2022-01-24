package me.riberr.discogskt.models.response.database.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val user: User,
    val community: Community
) {

    @Serializable
    data class User(
        @SerialName("in_collection")
        val inCollection: Int,
        @SerialName("in_wantlist")
        val inWantList: Int
    )

    @Serializable
    data class Community(
        @SerialName("in_collection")
        val inCollection: Int,
        @SerialName("in_wantlist")
        val inWantList: Int
    )
}