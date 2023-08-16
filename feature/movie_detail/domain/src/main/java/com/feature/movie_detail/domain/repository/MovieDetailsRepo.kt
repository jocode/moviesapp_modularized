package com.feature.movie_detail.domain.repository

import com.feature.movie_detail.domain.model.MovieDetails

interface MovieDetailsRepo {

    suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails
}