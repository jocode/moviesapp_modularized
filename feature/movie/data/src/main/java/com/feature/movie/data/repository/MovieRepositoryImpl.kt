package com.feature.movie.data.repository

import com.core.network.dataproviders.MovieDataProviders
import com.feature.movie.data.mappers.toDomainMovieList
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieDataProviders: MovieDataProviders
): MovieRepository {
    override suspend fun getMovieList(
        apiKey: String,
        query: String,
        language: String,
    ): List<Movie> {
        return movieDataProviders.getMovieList(
            apiKey = apiKey,
            query = query,
            language = language
        ).toDomainMovieList()
    }
}