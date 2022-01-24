package me.riberr.discogskt.oauth

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import me.riberr.discogskt.util.epochMillis

suspend fun requestToken(
    userAgent: String,
    consumerKey: String,
    consumerSecret: String,
    callback: String = ""
): Result<RequestToken> {
    val tokenClient = HttpClient {
        install(UserAgent) {
            agent = userAgent
        }
    }

    try {
        val response: HttpResponse = tokenClient.get("https://api.discogs.com/oauth/request_token") {
            parameter("oauth_consumer_key", consumerKey)
            parameter("oauth_signature", "$consumerSecret&")
            parameter("oauth_nonce", epochMillis())
            parameter("oauth_signature_method", "PLAINTEXT")
            parameter("oauth_timestamp", epochMillis())
            if (callback.isNotEmpty()) parameter("oauth_callback", "none")
        }
        val stringBody: String = response.receive()
        val params = stringBody.parseUrlEncodedParameters()
        val token = params["oauth_token"] ?: throw NullPointerException("oauth token is null")
        val secret = params["oauth_token_secret"] ?: throw NullPointerException("oauth secret is null")
        val callbackConfirmed = params["oauth_callback_confirmed"].toBoolean()

        return Result.success(
            RequestToken(
                token,
                secret,
                callbackConfirmed
            )
        )
    } catch (err: Exception) {
        return Result.failure(err)
    } finally {
        tokenClient.close()
    }
}

suspend fun accessToken(
    userAgent: String,
    consumerKey: String,
    consumerSecret: String,
    requestToken: RequestToken,
    verifierKey: String
): Result<AccessToken> {
    val tokenClient = HttpClient {
        install(UserAgent) {
            agent = userAgent
        }
    }

    try {
        val response: HttpResponse = tokenClient.post("https://api.discogs.com/oauth/access_token") {
            parameter("oauth_consumer_key", consumerKey)
            parameter("oauth_signature", "$consumerSecret&${requestToken.oauthTokenSecret}")
            parameter("oauth_nonce", epochMillis())
            parameter("oauth_signature_method", "PLAINTEXT")
            parameter("oauth_timestamp", epochMillis())
            parameter("oauth_token", requestToken.oauthToken)
            parameter("oauth_verifier", verifierKey)
        }
        val stringBody: String = response.receive()
        val params = stringBody.parseUrlEncodedParameters()
        val token = params["oauth_token"] ?: throw NullPointerException("oauth token is null")
        val secret = params["oauth_token_secret"] ?: throw NullPointerException("oauth secret is null")
        return Result.success(AccessToken(token, secret))
    } catch (err: Exception) {
        return Result.failure(err)
    } finally {
        tokenClient.close()
    }
}

