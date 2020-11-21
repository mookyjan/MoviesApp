package com.mudassir.domain.gateway

import com.mudassir.domain.entity.MovieListEntity
import io.reactivex.Single

interface MovieListGateWay {

    fun getMovieList(refresh: Boolean? = false): Single<MovieListEntity>
}