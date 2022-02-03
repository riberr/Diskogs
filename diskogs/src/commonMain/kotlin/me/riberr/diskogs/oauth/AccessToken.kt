package me.riberr.diskogs.oauth

import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
    val oauthToken: String,
    val oauthTokenSecret: String,
)