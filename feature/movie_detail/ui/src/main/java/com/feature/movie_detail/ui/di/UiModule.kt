package com.feature.movie_detail.ui.di

import com.feature.movie_detail.ui.navigation.MovieDetailsApi
import com.feature.movie_detail.ui.navigation.MovieDetailsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UiModule {

    @Provides
    fun provideMovieDetailsApi(): MovieDetailsApi {
        return MovieDetailsApiImpl()
    }

}