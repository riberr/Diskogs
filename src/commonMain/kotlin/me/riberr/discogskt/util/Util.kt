package me.riberr.discogskt.util

import kotlinx.datetime.Clock

fun epochMillis(): Long = Clock.System.now().toEpochMilliseconds()