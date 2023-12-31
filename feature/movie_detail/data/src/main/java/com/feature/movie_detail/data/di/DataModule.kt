package com.feature.movie_detail.data.di

import com.core.network.dataproviders.MovieDataProviders
import com.feature.movie_detail.data.repository.MovieDetailsRepoImpl
import com.feature.movie_detail.domain.repository.MovieDetailsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMovieDetailsRepo(movieDataProviders: MovieDataProviders): MovieDetailsRepo {
        return MovieDetailsRepoImpl(movieDataProviders)
    }

}