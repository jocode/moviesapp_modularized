package com.core.network.dataproviders

import com.core.network.ApiService
import com.core.network.model.MovieListResponse

class MovieDataProviders(
    private val apiService: ApiService
) {
    suspend fun getMovieList(
        apiKey: String,
        query: String,
        language: String = "en-US",
    ): MovieListResponse {
        return apiService.getMovieList(
            apiKey = apiKey,
            query = query,
            language = language
        )
    }
}