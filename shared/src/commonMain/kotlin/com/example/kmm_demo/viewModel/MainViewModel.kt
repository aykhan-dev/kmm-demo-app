package com.example.kmm_demo.viewModel

import com.example.kmm_demo.base.BaseViewModel
import com.example.kmm_demo.provider.UseCaseProvider

class MainViewModel : BaseViewModel() {

    private val fetchPostsUseCase = UseCaseProvider.provideFetchPostsUseCase()

    fun fetchPosts() = provideFlow<State> {
        emit(State.Loading)

        val response = fetchPostsUseCase.execute()
        emit(State.Result(response))
    }

}

sealed class State {

    object Loading : State()

    data class Result<T>(val data: T) : State()

}