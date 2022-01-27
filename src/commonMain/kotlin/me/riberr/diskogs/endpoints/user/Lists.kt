package me.riberr.diskogs.endpoints.user

import me.riberr.diskogs.Diskogs
import me.riberr.diskogs.endpoints.Endpoint
import me.riberr.diskogs.endpoints.User

val User.lists: Lists
    get() = Lists(this.diskogs)

class Lists(override val diskogs: Diskogs) : Endpoint