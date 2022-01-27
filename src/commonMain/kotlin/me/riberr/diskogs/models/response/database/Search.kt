package me.riberr.diskogs.models.response.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.pagination.Pagination
import me.riberr.diskogs.models.response.database.common.Format


@Serializable
data class Search(
    var results: List<Result> = listOf(),
    val pagination: Pagination
) {

    enum class Type(val value: String) {
        RELEASE("release"),
        MASTER("master"),
        ARTIST("artist"),
        LABEL("label")
    }

    @Serializable
    data class Result(
        var id: Int,
        var style: List<String> = listOf(),
        var thumb: String,
        var title: String,
        var country: String?,
        var format: List<String> = listOf(),
        var uri: String,
        var community: Community?,
        var label: List<String> = listOf(),
        @SerialName("catno")
        var catNo: String?,
        var year: Int?,
        var genre: List<String> = listOf(),
        @SerialName("resource_url")
        var resourceUrl: String,
        var type: String,
        var barcode: List<String> = listOf(),
        @SerialName("user_data")
        var userData: UserData,
        @SerialName("master_id")
        var masterId: Int?,
        @SerialName("master_url")
        var masterUrl: String?,
        @SerialName("cover_image")
        var coverImage: String,
        @SerialName("format_quantity")
        var formatQuantity: Int?,
        var formats: List<Format> = listOf()
    )

    @Serializable
    data class UserData(
        @SerialName("in_wantlist")
        val inWantlist: Boolean,
        @SerialName("in_collection")
        val inCollection: Boolean
    )

    @Serializable
    data class Community(
        var want: Int,
        var have: Int
    )
}