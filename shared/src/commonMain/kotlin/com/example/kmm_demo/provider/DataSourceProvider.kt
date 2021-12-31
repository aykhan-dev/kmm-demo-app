package com.example.kmm_demo.provider

import com.example.kmm_demo.dataSource.PostsDS
import com.example.kmm_demo.dataSource.PostsDSI
import com.example.kmm_demo.network.httpClient

object DataSourceProvider {

    fun providePostsDS(): PostsDS {
        return PostsDSI(client = httpClient)
    }

}