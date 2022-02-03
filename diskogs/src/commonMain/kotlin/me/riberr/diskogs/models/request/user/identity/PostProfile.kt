package me.riberr.diskogs.models.request.user.identity

import kotlinx.serialization.Serializable

@Serializable
data class PostProfile(
    val username: String,
    val name: String?,
    val homePage: String?,
    val location: String?,
    val profile: String?,
    val currAbbr: String?
)