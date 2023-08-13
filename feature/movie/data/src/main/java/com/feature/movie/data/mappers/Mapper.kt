package com.feature.movie.data.mappers

import com.core.network.model.MovieListResponse
import com.feature.movie.domain.model.Movie

fun MovieListResponse.toDomainMovieList() = results.map {
    Movie(
        id = it.id,
        title = it.title,
        overview = it.overview,
        posterPath = it.posterPath,
        backdropPath = it.backdropPath,
        voteAverage = it.voteAverage,
        releaseDate = it.releaseDate,
        popularity = it.popularity,
        voteCount = it.voteCount,
        adult = it.adult,
        originalLanguage = it.originalLanguage,
        originalTitle = it.originalTitle,
        video = it.video,
        genreIds = it.genreIds,
    )
}