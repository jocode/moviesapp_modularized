package com.core.common

/**
 * A generic class that holds a value with its loading status.
 */
sealed class UiEvent<T> {
    class Loading<T> : UiEvent<T>()
    data class Success<T>(val data: T) : UiEvent<T>()
    data class Error<T>(val message: String) : UiEvent<T>()
}
