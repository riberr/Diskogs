package me.riberr.discogskt.endpoints.user

import me.riberr.discogskt.DiscogsKt
import me.riberr.discogskt.endpoints.Endpoint
import me.riberr.discogskt.endpoints.User

val User.wantList: WantList
    get() = WantList(this.discogsKt)

class WantList(override val discogsKt: DiscogsKt) : Endpoint