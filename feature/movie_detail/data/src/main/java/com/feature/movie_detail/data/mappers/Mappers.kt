package com.feature.movie_detail.data.mappers

import com.core.network.model.MovieDetailsDto
import com.feature.movie_detail.domain.model.MovieDetails

fun MovieDetailsDto.toDomain() = MovieDetails(
    title = title,
    desc = overview,
    imageUrl = posterPath.makeFullUrl()
)

fun String.makeFullUrl() = "https://image.tmdb.org/t/p/w500/$this"