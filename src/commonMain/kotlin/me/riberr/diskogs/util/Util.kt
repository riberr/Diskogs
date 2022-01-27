package me.riberr.diskogs.util

import kotlinx.datetime.Clock

fun epochMillis(): Long = Clock.System.now().toEpochMilliseconds()