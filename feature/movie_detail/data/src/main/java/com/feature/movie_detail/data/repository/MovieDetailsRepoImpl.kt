package com.feature.movie_detail.data.repository

import com.core.network.dataproviders.MovieDataProviders
import com.feature.movie_detail.data.mappers.toDomain
import com.feature.movie_detail.domain.model.MovieDetails
import com.feature.movie_detail.domain.repository.MovieDetailsRepo

class MovieDetailsRepoImpl(
    private val movieDataProviders: MovieDataProviders,
) : MovieDetailsRepo {
    override suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails {
        return movieDataProviders.getMovieDetails(id, apiKey).toDomain()
    }
}