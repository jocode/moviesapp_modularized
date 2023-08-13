package com.core.network

import com.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/search/movie?api_key=1f54bd990f1cdfb230adb312546d765d&language=en-US&query=batman&page=1&include_adult=false")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("language") language: String = "en-US",
    ): MovieListResponse

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
    }
}
