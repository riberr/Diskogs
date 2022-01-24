package me.riberr.discogskt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

actual val testCoroutineContext: CoroutineContext =
    newSingleThreadContext("testRunner")

actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }