package me.riberr.discogskt

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

// https://github.com/Kotlin/kotlinx.coroutines/issues/1996
expect fun runBlockingTest(block: suspend CoroutineScope.()-> Unit)
expect val testCoroutineContext: CoroutineContext