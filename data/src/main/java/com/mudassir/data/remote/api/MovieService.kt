package com.mudassir.data.remote.api

import com.mudassir.data.remote.model.MovieDetailResponse
import com.mudassir.data.remote.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

//    ?primary_release_date.lte=2016-12-31&sort_by=release_date.desc&page=1
    @GET("discover/movie")
    fun getMovieList(@Query("primary_release_date.lte") releaseDate: String = "2020-11-11",
                     @Query("sort_by") sortBy :String="release_date.desc",
                     @Query("page") page :Int =1
    ) : Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int ) : Single<MovieDetailResponse>
}