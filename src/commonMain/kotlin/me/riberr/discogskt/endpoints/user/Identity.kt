package me.riberr.discogskt.endpoints.user

import me.riberr.discogskt.DiscogsKt
import me.riberr.discogskt.endpoints.Endpoint
import me.riberr.discogskt.endpoints.User

val User.identity: Identity
    get() = Identity(this.discogsKt)

class Identity(override val discogsKt: DiscogsKt) : Endpoint