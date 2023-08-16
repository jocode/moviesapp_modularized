package com.example.moviesapp_modularized.di

import com.example.moviesapp_modularized.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_detail.ui.navigation.MovieDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNavigationProvider(
        movieApi: MovieApi,
        movieDetailsApi: MovieDetailsApi,
    ): NavigationProvider = NavigationProvider(
        movieApi = movieApi,
        movieDetailsApi = movieDetailsApi
    )



}