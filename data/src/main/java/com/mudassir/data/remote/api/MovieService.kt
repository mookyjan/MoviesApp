package com.mudassir.data.remote.api

import com.mudassir.data.remote.model.MovieResponse
import com.mudassir.data.util.ApiCallback
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie")
    fun getMovieList(@Query("primary_release_date.lte") releaseDate: String = "2020-11-11",
                     @Query("sort_by") sortBy :String="release_date.desc",
                     @Query("page") page :Int =1
    ) : Single<MovieResponse>
}