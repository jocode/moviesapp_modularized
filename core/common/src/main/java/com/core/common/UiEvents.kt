package com.core.common

/**
 * A generic class that holds a value with its loading status.
 */
sealed class UiEvents<T> {
    class Loading<T> : UiEvents<T>()
    data class Success<T>(val data: T) : UiEvents<T>()
    data class Error<T>(val message: String) : UiEvents<T>()
}
