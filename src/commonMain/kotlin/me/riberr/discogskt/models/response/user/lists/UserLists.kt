package me.riberr.discogskt.models.response.user.lists

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.riberr.discogskt.models.pagination.Pagination
import kotlin.collections.List

@Serializable
data class UserLists(
    val pagination: Pagination,
    val lists: List<UserList> = listOf()
) {
    @Serializable
    data class UserList(
        val id: Int,
        @SerialName("date_added")
        val dateAdded: String,
        @SerialName("date_changed")
        val dateChanged: String,
        val name: String,
        val uri: String,
        @SerialName("resource_url")
        val resourceUrl: String,
        val public: Boolean,
        val description: String
    )
}