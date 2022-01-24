package me.riberr.discogskt

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch
import me.riberr.discogskt.oauth.RequestToken
import me.riberr.discogskt.util.epochMillis
import kotlin.test.Test

class OAuthTest {

    private val consumerKey = "pUYJFjFdnqfynRRfGIsw"
    private val consumerSecret = "eyjMJARWgjfXxbkWGgdWTRqFYRrjamyZ"

    @Test
    fun testRequestOAuthToken() = runBlockingTest {

        launch {
            val requestToken = DiscogsKt.requestTokenOauth(
                "FooBarApp/3.0",
                consumerKey,
                consumerSecret,
                //"callbackkk"
            )
            requestToken.onSuccess {
                println(it)
                println(it.oauthAuthUrl)
            }
        }
    }

    @Test
    fun testAccessToken() = runBlockingTest {

        val requestToken = RequestToken(
            //"OjEdVWtmphYIqPJZgcaSYUzjkXjAOXiHNdvoroNs",
            //"SnRLSPdzRyYCeNyTpZHDKULAwRUWUctYbHfwkTZL"
            "rRCDjNXZqAdMedxYSrhoPcWumwGSPTwdoXDIJhvf",
            "AZAMGgAFgAkCRrflGQEqRhXyQsiiKmQTuNwjrynv"
        )
        val verifierKey = "MXbvxZSgIW"
        launch {
            DiscogsKt.accessTokenOauth(
                "FooBarApp/3.0",
                consumerKey,
                consumerSecret,
                requestToken,
                verifierKey
            )

        }
    }

    @Test
    fun testUseAccessToken() = runBlockingTest {
        /* test */
        val oauthClient = HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }

            install(UserAgent) {
                agent = "FooBarApp/3.0"
            }

            install(Logging) {
                level = LogLevel.ALL
            }
        }

        val response: HttpResponse = oauthClient.get("https://api.discogs.com/oauth/identity") {

            //header("oauth_token_secret", "gFJJBDzbchvqRiBsnJKRKxLGGlUqiwgEeqhsSLfG")

            parameter("oauth_consumer_key", consumerKey)
            parameter("oauth_nonce", epochMillis())
            parameter("oauth_signature_method", "PLAINTEXT")
            parameter("oauth_timestamp", epochMillis())
            parameter("oauth_token", "gkGzrgKeMMOienyTfRqBFImTlvPGQXkMqITmNoyM")
            parameter("oauth_signature", "$consumerSecret&gFJJBDzbchvqRiBsnJKRKxLGGlUqiwgEeqhsSLfG")
        }
        val stringBody: String = response.receive()
        println(stringBody)
    }

}