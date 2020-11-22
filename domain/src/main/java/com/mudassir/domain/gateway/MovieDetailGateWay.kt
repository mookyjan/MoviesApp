package com.mudassir.domain.gateway

import com.mudassir.domain.entity.MovieDetailEntity
import io.reactivex.Single

interface MovieDetailGateWay {

    fun getMovieDetail(movieId: Int): Single<MovieDetailEntity>
}