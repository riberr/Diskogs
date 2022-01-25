# DiscogsKt - API wrapper for Discogs in Kotlin Multiplatform

## Todo
json mode  
better fault handling  
mock api testing  
usage guide  
rate limit handling  

### Implemented endpoint groups
- [x] Authentication
- [x] Database
- [x] User identity
- [ ] Images
- [ ] Marketplace
- [ ] Inventory export
- [ ] User collection
- [ ] User wantlist
- [ ] User List

## Get started

### Gradle
todo

## Usage

Create your client:
```kotlin
val discogsKt = DiscogsKt.create("MyUserAgent/1.0")
```

As per Discogs documentation, your application must provide a user agent that identifies itself. Make it unique and preferably follow RFC 1945:

Make some requests:
```kotlin
// All endpoints return value or throwable encapsulated in Result<>
discogsKt.database.getArtist(666)
        .onSuccess { println(it) }
        .onFailure { error(it) }

// Another style
val artist = discogsKt.database.getArtist(666).getOrThrow()
```

Some endpoints supports pagination:
```kotlin
discogsKt.database.getArtistReleases(666, ArtistReleases.Sort.TITLE, page = 0, perPage = 20)
    .onSuccess { it.releases.forEach { release -> release.title } }
    .onFailure { error(it) }
```

### Log level
It is possible to set the log level of the ktor client upon creating the discogsKt client:
```kotlin
val discogsKt = DiscogsKt.create(
            "MyUserAgent/1.0",
            logLevel = LogLevel.ALL
        )
```

### Authorizing with OAuth flow
The following example shows how to authorize using OAuth 1.0:
```kotlin
// This particular example is written in kotlin/jvm 
suspend fun main(args: Array<String>) {
    // Your application must provide a User-Agent string that identifies itself,
    // preferably something that follows RFC 1945:
    // https://datatracker.ietf.org/doc/html/rfc1945#section-3.7
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
    //  so you should persist these tokens to make future requests signed with OAuth
    val accessToken = DiscogsKt.accessTokenOauth(
        userAgent, consumerKey, consumerSecret, requestToken, verifierKey
    ).getOrElse { error(it) }
    println("accessToken: $accessToken")

    // Create the client that will be used for all future requests to discogs endpoints
    val discogsKt = DiscogsKt.create(userAgent, consumerKey, consumerSecret, accessToken)

    // Example request
    discogsKt.user.getIdentity()
        .onSuccess {
            println("user id: ${it.id}")
            println("user name: ${it.username}")
            println("user url: ${it.resourceUrl}")
        }
}
```


For more information, see: https://www.discogs.com/developers#page:authentication,header:authentication-discogs-auth-flow

## Resources
https://www.discogs.com/developers#page:home   
https://ktor.io/docs/welcome.html   