package com.mudassir.data.gateway

import com.mudassir.data.mapper.MovieDetailToDomainMapper
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.entity.MovieDetailEntity
import com.mudassir.domain.gateway.MovieDetailGateWay
import io.reactivex.Single

class MovieDetailGateWayImpl (private val movieListRepository: MovieListRepository): MovieDetailGateWay {

    override fun getMovieDetail(movieId: Int): Single<MovieDetailEntity> {
        return movieListRepository.getMovieDetail(movieId).map {
            MovieDetailToDomainMapper.transformFrom(it)
        }
    }


}