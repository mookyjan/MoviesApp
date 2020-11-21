package com.mudassir.data.repository

import com.mudassir.data.remote.GetMovieListRemoteDataSource
import com.mudassir.data.remote.model.MovieResponse
import io.reactivex.Single

class MovieListRepository(private val getMovieListRemoteDataSource: GetMovieListRemoteDataSource) {

    fun getAudioBookList(refresh: Boolean? = false) : Single<MovieResponse>{
        val remoteData = getMovieListRemoteDataSource.getMovieList()
        return remoteData
    }
}