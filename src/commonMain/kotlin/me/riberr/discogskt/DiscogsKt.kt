package me.riberr.discogskt

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import me.riberr.discogskt.oauth.AccessToken
import me.riberr.discogskt.oauth.RequestToken
import me.riberr.discogskt.oauth.accessToken
import me.riberr.discogskt.oauth.requestToken
import me.riberr.discogskt.util.epochMillis

class DiscogsKt private constructor(
    private val userAgent: String,
    private val userToken: String = "",
    private val consumerKey: String = "",
    private val consumerSecret: String = "",
    private val oauthToken: String = "",
    private val oauthTokenSecret: String = "",
    private val logLevel: LogLevel = LogLevel.NONE,
    //private val engine: HttpClientEngine?,
    //private val jsonMode: Boolean = false
) {
    internal val client = HttpClient {
        defaultRequest {
            host = "api.discogs.com"
            url { protocol = URLProtocol.HTTPS }

            if (userToken.isNotEmpty()) {
                header("Authorization", "Discogs token=$userToken")
            } else if (oauthToken.isNotEmpty() && oauthTokenSecret.isNotEmpty()) {
                parameter("oauth_consumer_key", consumerKey)
                parameter("oauth_nonce", epochMillis())
                parameter("oauth_signature_method", "PLAINTEXT")
                parameter("oauth_timestamp", epochMillis())
                parameter("oauth_token", oauthToken)
                parameter("oauth_signature", "$consumerSecret&$oauthTokenSecret")
            } else if (consumerKey.isNotEmpty() && consumerSecret.isNotEmpty()) {
                header("Authorization", "Discogs key=$consumerKey, secret=$consumerSecret")
            }
        }

        install(UserAgent) {
            agent = userAgent
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                encodeDefaults = false // don't serialize nulls
                prettyPrint = true
                //isLenient = true
                explicitNulls = false
            })
        }

        install(Logging) {
            level = logLevel
        }
    }


    fun close() {
        client.close()
    }

    companion object {
        suspend fun requestTokenOauth(
            userAgent: String? = null,
            consumerKey: String,
            consumerSecret: String,
            callback: String = ""
        ): Result<RequestToken> {
            return requestToken(
                getUserAgent(userAgent),
                consumerKey,
                consumerSecret,
                callback
            )
        }

        suspend fun accessTokenOauth(
            userAgent: String? = null,
            consumerKey: String,
            consumerSecret: String,
            requestToken: RequestToken,
            verifierKey: String
        ): Result<AccessToken> {
            return accessToken(
                getUserAgent(userAgent),
                consumerKey,
                consumerSecret,
                requestToken,
                verifierKey
            )
        }

        fun create(
            userAgent: String? = null,
            logLevel: LogLevel = LogLevel.NONE
        ): DiscogsKt {
            return DiscogsKt(
                getUserAgent(userAgent),
                logLevel = logLevel
            )
        }

        fun create(
            userAgent: String? = null,
            userToken: String,
            logLevel: LogLevel = LogLevel.NONE
        ): DiscogsKt {
            return DiscogsKt(
                getUserAgent(userAgent),
                userToken = userToken,
                logLevel = logLevel
            )
        }

        fun create(
            userAgent: String? = null,
            consumerKey: String,
            consumerSecret: String,
            logLevel: LogLevel = LogLevel.NONE
        ): DiscogsKt {
            return DiscogsKt(
                getUserAgent(userAgent),
                consumerKey = consumerKey,
                consumerSecret = consumerSecret,
                logLevel = logLevel
            )
        }

        fun create(
            userAgent: String? = null,
            consumerKey: String,
            consumerSecret: String,
            accessToken: AccessToken,
            logLevel: LogLevel = LogLevel.NONE
        ): DiscogsKt {
            return DiscogsKt(
                getUserAgent(userAgent),
                consumerKey = consumerKey,
                consumerSecret = consumerSecret,
                oauthToken = accessToken.oauthToken,
                oauthTokenSecret = accessToken.oauthTokenSecret,
                logLevel = logLevel
            )
        }

        private fun getUserAgent(s: String?): String {
            // todo: get version from build.gradle.kts
            return if (s.isNullOrBlank()) "DiscogsKtClient/0.0.1}" else s
        }
    }
}