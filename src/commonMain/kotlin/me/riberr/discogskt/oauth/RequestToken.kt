package me.riberr.discogskt.oauth

import kotlinx.serialization.Serializable

@Serializable
data class RequestToken(
    val oauthToken: String,
    val oauthTokenSecret: String,
    val oauthCallbackConfirmed: Boolean? = false
) {
    val oauthAuthUrl: String = "https://discogs.com/oauth/authorize?oauth_token=$oauthToken"
}