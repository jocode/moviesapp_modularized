package com.feature.movie_detail.ui.screens

import com.feature.movie_detail.domain.model.MovieDetails

data class MovieDetailsStateHolder(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null,
)
