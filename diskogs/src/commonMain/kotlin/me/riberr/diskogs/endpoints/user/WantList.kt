package me.riberr.diskogs.endpoints.user

import me.riberr.diskogs.Diskogs
import me.riberr.diskogs.endpoints.Endpoint
import me.riberr.diskogs.endpoints.User

val User.wantList: WantList
    get() = WantList(this.diskogs)

class WantList(override val diskogs: Diskogs) : Endpoint