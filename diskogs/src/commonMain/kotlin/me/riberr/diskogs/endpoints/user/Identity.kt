package me.riberr.diskogs.endpoints.user

import me.riberr.diskogs.Diskogs
import me.riberr.diskogs.endpoints.Endpoint
import me.riberr.diskogs.endpoints.User

val User.identity: Identity
    get() = Identity(this.diskogs)

class Identity(override val diskogs: Diskogs) : Endpoint