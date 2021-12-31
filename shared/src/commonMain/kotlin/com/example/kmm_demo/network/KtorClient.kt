package com.example.kmm_demo.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

val httpClient = HttpClient(CIO) {
    install(Logging) {
        level = LogLevel.ALL
    }
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

const val BASE_URL = "https://jsonplaceholder.typicode.com"

const val GET_POSTS_URL = "$BASE_URL/posts"