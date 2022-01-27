package me.riberr.diskogs.util

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

suspend inline fun <reified T> HttpClient.get(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
): Result<T> = this.request(urlString, HttpMethod.Get, block)

suspend inline fun <reified T> HttpClient.post(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
): Result<T> = this.request(urlString, HttpMethod.Post, block)

suspend inline fun <reified T> HttpClient.put(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
): Result<T> = this.request(urlString, HttpMethod.Put, block)

suspend inline fun <reified T> HttpClient.delete(
    urlString: String,
    block: HttpRequestBuilder.() -> Unit = {}
): Result<T> = this.request(urlString, HttpMethod.Delete, block)

suspend inline fun <reified T> HttpClient.request(
    urlString: String,
    httpMethod: HttpMethod,
    block: HttpRequestBuilder.() -> Unit = {}
): Result<T> {
    return try {
        Result.success(
            this.request(urlString) {
                method = httpMethod
                block()
            } as T
        )
    } catch (err: Exception) {
        Result.failure(err)
    }
}
