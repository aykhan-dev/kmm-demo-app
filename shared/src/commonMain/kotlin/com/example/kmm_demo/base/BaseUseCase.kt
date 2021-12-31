package com.example.kmm_demo.base

abstract class BaseUseCase<T, out G>(val params: T) {

    protected abstract suspend fun process(params: T): G

    suspend fun execute(): G {
        return process(params)
    }

}