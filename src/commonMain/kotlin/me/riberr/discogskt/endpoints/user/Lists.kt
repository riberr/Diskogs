package me.riberr.discogskt.endpoints.user

import me.riberr.discogskt.DiscogsKt
import me.riberr.discogskt.endpoints.Endpoint
import me.riberr.discogskt.endpoints.User

val User.lists: Lists
    get() = Lists(this.discogsKt)

class Lists(override val discogsKt: DiscogsKt) : Endpoint