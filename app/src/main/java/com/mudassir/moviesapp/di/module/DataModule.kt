package com.mudassir.moviesapp.di.module

import com.mudassir.data.gateway.MovieListGateWayImpl
import com.mudassir.data.remote.GetMovieListRemoteDataSource
import com.mudassir.data.remote.api.MovieService
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.gateway.MovieListGateWay
import dagger.Module
import dagger.Provides


@Module
class DataModule {

    @Provides
    fun provideMovieListRemoteDataSource(movieService: MovieService)
            = GetMovieListRemoteDataSource(movieService)


    @Provides
    fun provideMovieRepository(movieRemoteDataSource: GetMovieListRemoteDataSource)
            = MovieListRepository(movieRemoteDataSource)

    @Provides
    fun provideMovieGateWay(movieListRepository: MovieListRepository): MovieListGateWay
            = MovieListGateWayImpl(movieListRepository)

}