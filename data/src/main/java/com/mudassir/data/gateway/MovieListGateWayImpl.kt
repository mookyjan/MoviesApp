package com.mudassir.data.gateway

import com.mudassir.data.local.mapper.MovieListToDomainMapper
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.entity.MovieListEntity
import com.mudassir.domain.gateway.MovieListGateWay
import io.reactivex.Single

class MovieListGateWayImpl (private val movieListRepository: MovieListRepository): MovieListGateWay{

    override fun getMovieList(refresh: Boolean?): Single<MovieListEntity> {
        return movieListRepository.getAudioBookList(refresh)
            .map {
                MovieListToDomainMapper.transformFrom(it)
        }
    }

}