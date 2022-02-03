package me.riberr.diskogs.endpoints

import me.riberr.diskogs.Diskogs

val Diskogs.user: User
    get() = User(this)

class User(override val diskogs: Diskogs) : Endpoint