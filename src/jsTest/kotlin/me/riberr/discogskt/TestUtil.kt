package me.riberr.discogskt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.promise
import kotlin.coroutines.CoroutineContext

//val testScope = MainScope()
//actual val testCoroutineContext: CoroutineContext = testScope.coroutineContext
//actual fun runBlockingTest(block: suspend () -> Unit): dynamic = testScope.promise { block() }

val testScope = MainScope()
actual val testCoroutineContext: CoroutineContext = testScope.coroutineContext
actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit): dynamic = testScope.promise { this.block() }