package com.mudassir.data.remote

import com.mudassir.data.remote.api.MovieService
import com.mudassir.data.remote.model.MovieResponse
import io.reactivex.Single

class GetMovieListRemoteDataSource (private val movieService: MovieService ) {

    fun getMovieList(page:Int) : Single<MovieResponse>
     = movieService.getMovieList(page=page)

}