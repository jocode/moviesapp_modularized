package com.feature.movie.ui.screen

import com.feature.movie.domain.model.Movie

data class MovieSearchStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie> = emptyList(),
    val error: String = "",
)
