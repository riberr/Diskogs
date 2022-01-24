package me.riberr.discogskt.endpoints

import me.riberr.discogskt.DiscogsKt

val DiscogsKt.database: Database
    get() = Database(this)

class Database(override val discogsKt: DiscogsKt) : Endpoint