# DiscogsKt - API wrapper for Discogs in Kotlin Multiplatform

## Todo
json mode  
better fault handling  
mock api testing  
usage guide  
rate limit handling  

### database endpoints
- [x] Release
- [x] Get Release Rating By User  
- [ ] Update Release Rating By User DOESNT WORK? 500 internal server error  
- [x] Delete Release Rating By User  
- [x] Community Release Rating  
- [x] Release Stats  
- [x] Master Release  
- [x] Master Release Versions  
- [x] Artist  
- [x] Artist Releases  
- [x] Label  
- [x] All Label Releases  
- [x] Search  
- [x] Videos  

### user identity endpoints
- [x] Identity
- [x] Get Profile
- [x] Edit Profile
- [x] User Submissions
- [x] User Contributions
- [x] User Collection

## Inspiration
https://github.com/StarryBlueSky/Penicillin

## Usage

### Authorizing with OAuth flow

```kotlin
// This particular example is written in kotlin/jvm 
suspend fun main(args: Array<String>) {
    // Your application must provide a User-Agent string that identifies itself,
    // preferably something that follows RFC 1945: https://datatracker.ietf.org/doc/html/rfc1945#section-3.7
    val userAgent: String = args[0]

    // Application registration can be found here: https://www.discogs.com/settings/developers
    val consumerKey: String = args[1]
    val consumerSecret: String = args[2]

    // Request token expires after 15 min
    val requestToken = DiscogsKt.requestTokenOauth(userAgent, consumerKey, consumerSecret)
        .getOrElse { error(it) }
    println("requestToken: $requestToken")

    // This page will ask the user to authorize your app on behalf of their Discogs account.
    // If they accept and authorize, they will receive a verifier key to use as verification
    println("browse to ${requestToken.oauthAuthUrl} and input verifier key")
    print("Verifier key: ")
    val verifierKey: String = readLine() ?: throw Exception("user must input verifier key")

    //  These tokens do not expire (unless the user revokes access from your app),
    //  so you should store these tokens in a database or persistent storage to make future requests signed with OAuth
    val accessToken = DiscogsKt.accessTokenOauth(userAgent, consumerKey, consumerSecret, requestToken, verifierKey)
        .getOrElse { error(it) }
    println("accessToken: $accessToken")

    // Create the client that will be used for all future requests to discogs endpoints
    val discogsKt = DiscogsKt.create(userAgent, consumerKey, consumerSecret, accessToken)

    // Example request
    discogsKt.user.getIdentity().onSuccess {
        println("user id: ${it.id}")
        println("user name: ${it.username}")
        println("user url: ${it.resourceUrl}")
    }
}
```

For more information, see: https://www.discogs.com/developers#page:authentication,header:authentication-discogs-auth-flow