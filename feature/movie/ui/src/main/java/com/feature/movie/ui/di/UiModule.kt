package com.feature.movie.ui.di

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie.ui.navigation.MovieApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UiModule {

    @Provides
    fun provideMovieApi(): MovieApi = MovieApiImpl()

}