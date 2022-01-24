package me.riberr.discogskt.endpoints

import me.riberr.discogskt.DiscogsKt

val DiscogsKt.user: User
    get() = User(this)

class User(override val discogsKt: DiscogsKt) : Endpoint