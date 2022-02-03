package me.riberr.diskogs.models.response.user.identity

import kotlinx.serialization.Serializable
import me.riberr.diskogs.models.pagination.Pagination
import me.riberr.diskogs.models.response.database.Release

@Serializable
data class Contributions(
    val pagination: Pagination,
    val contributions: List<Release> = listOf()
) {
    //todo: move to request
    enum class Sort(val value: String) {
        LABEL("label"),
        ARTIST("artist"),
        TITLE("title"),
        CATNO("catno"),
        FORMAT("format"),
        RATING("rating"),
        YEAR("year"),
        ADDED("added")
    }

    enum class SortOrder(val value: String) {
        ASC("asc"),
        DESC("desc")
    }
}