package me.riberr.discogskt.models.request.user

import kotlinx.serialization.Serializable

@Serializable
data class EditProfileReq(
    val username: String,
    val name: String?,
    val homePage: String?,
    val location: String?,
    val profile: String?,
    val currAbbr: String?
)