package com.example.kmm_demo.base

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel {

    private val exceptionHandler = CoroutineExceptionHandler(::onError)
    private val coroutineContext = Dispatchers.Unconfined + exceptionHandler

    private val scope = CoroutineScope(coroutineContext)

    private fun onError(coroutineContext: CoroutineContext?, throwable: Throwable) {
        when (throwable) {
            else -> {
                println(throwable.toString())
            }
        }
    }

    protected fun doAsync(block: suspend () -> Unit) {
        scope.launch {
            block()
        }
    }

    protected fun <T> provideFlow(block: suspend FlowCollector<T>.() -> Unit): Flow<T> {
        return flow(block)
            .catch { onError(null, it) }
            .flowOn(coroutineContext)
    }

    fun onClear() {
        scope.cancel()
    }

}