package me.riberr.diskogs.endpoints

import me.riberr.diskogs.Diskogs

val Diskogs.database: Database
    get() = Database(this)

class Database(override val diskogs: Diskogs) : Endpoint