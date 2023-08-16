package com.example.moviesapp_modularized.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_detail.ui.navigation.MovieDetailsApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailsApi,
)
