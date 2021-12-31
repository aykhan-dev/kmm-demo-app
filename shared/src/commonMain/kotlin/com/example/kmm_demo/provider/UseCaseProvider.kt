package com.example.kmm_demo.provider

import com.example.kmm_demo.usecase.MainUseCase

object UseCaseProvider {

    private val postsDS get() = DataSourceProvider.providePostsDS()

    fun provideFetchPostsUseCase(): MainUseCase.FetchPosts {
        return MainUseCase.FetchPosts(postsDS = postsDS)
    }

}