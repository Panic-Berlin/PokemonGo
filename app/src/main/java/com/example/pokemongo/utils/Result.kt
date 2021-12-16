package com.example.pokemongo.utils

sealed class RequestResult<out T : Any> {
    data class Success<T : Any>(val data: T) : RequestResult<T>()
    sealed class Failed : RequestResult<Nothing>() {
        data class Error(val throwable: Throwable) : Failed()
    }
}

inline fun <T : Any> safeRequest(block: () -> T): RequestResult<T> = try {
    RequestResult.Success(block.invoke())
} catch (exception: Exception) {
    RequestResult.Failed.Error(exception)
}
