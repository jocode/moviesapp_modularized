package com.feature.movie_detail.domain.di

import com.feature.movie_detail.domain.repository.MovieDetailsRepo
import com.feature.movie_detail.domain.use_cases.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetMovieDetailsUseCase(
        movieDetailsRepo: MovieDetailsRepo,
    ): GetMovieDetailsUseCase = GetMovieDetailsUseCase(movieDetailsRepo)

}