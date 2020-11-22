package com.mudassir.data.repository

import com.mudassir.data.remote.GetMovieListRemoteDataSource
import com.mudassir.data.remote.model.MovieDetailResponse
import com.mudassir.data.remote.model.MovieResponse
import io.reactivex.Single

class MovieListRepository(private val getMovieListRemoteDataSource: GetMovieListRemoteDataSource) {

    fun getMovieList(refresh: Boolean? = false,page : Int) : Single<MovieResponse>{
        val remoteData = getMovieListRemoteDataSource.getMovieList(page)

        return remoteData
    }

    fun getMovieDetail(movieId: Int) : Single<MovieDetailResponse>{
        return getMovieListRemoteDataSource.getMovieDetail(movieId)
    }
}