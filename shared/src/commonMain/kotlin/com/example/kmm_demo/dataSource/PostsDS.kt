package com.example.kmm_demo.dataSource

import com.example.kmm_demo.network.GET_POSTS_URL
import com.example.kmm_demo.pojo.PostPOJO
import io.ktor.client.*
import io.ktor.client.request.*

interface PostsDS {

    suspend fun getPosts(): List<PostPOJO>

}

class PostsDSI(private val client: HttpClient) : PostsDS {

    override suspend fun getPosts(): List<PostPOJO> {
        return client.get(GET_POSTS_URL)
    }

}