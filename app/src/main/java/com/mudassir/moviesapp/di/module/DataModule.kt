package com.mudassir.moviesapp.di.module

import android.content.Context
import com.mudassir.data.gateway.MovieListGateWayImpl
import com.mudassir.data.local.GetMovieListLocalDataSource
import com.mudassir.data.local.dao.AudioBookDao
import com.mudassir.data.local.db.AudioBookDatabase
import com.mudassir.data.remote.GetMovieListRemoteDataSource
import com.mudassir.data.remote.api.MovieService
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.gateway.MovieListGateWay
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideAudioBookRemoteDataSource(audioBookService: MovieService)
            = GetMovieListRemoteDataSource(audioBookService)


    @Provides
    @Singleton
    fun provideAudioBookDatabase(context: Context) =
        AudioBookDatabase.newInstance(context)

    @Provides
    @Singleton
    fun provideAudioBookDao(audioBookDatabase: AudioBookDatabase)
            = audioBookDatabase.audioBookDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(audioBookDao: AudioBookDao)
            = GetMovieListLocalDataSource(audioBookDao)

    @Provides
    fun provideAudioBookRepository(audioBooksRemoteDataSource: GetMovieListRemoteDataSource,audioBookLocalDataSource: GetMovieListLocalDataSource)
            = MovieListRepository(audioBooksRemoteDataSource,audioBookLocalDataSource)

    @Provides
    fun provideAudioBookGateWay(audioBookRepository: MovieListRepository): MovieListGateWay
            = MovieListGateWayImpl(audioBookRepository)

}