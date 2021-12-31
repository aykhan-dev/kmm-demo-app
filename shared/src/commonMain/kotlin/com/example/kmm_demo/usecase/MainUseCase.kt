package com.example.kmm_demo.usecase

import com.example.kmm_demo.base.BaseUseCase
import com.example.kmm_demo.dataSource.PostsDS
import com.example.kmm_demo.dataSource.PostsDSI
import com.example.kmm_demo.pojo.PostPOJO

class MainUseCase {

    class FetchPosts(private val postsDS: PostsDS) : BaseUseCase<Unit, List<PostPOJO>>(Unit) {

        override suspend fun process(params: Unit): List<PostPOJO> {
            return postsDS.getPosts()
        }

    }

}