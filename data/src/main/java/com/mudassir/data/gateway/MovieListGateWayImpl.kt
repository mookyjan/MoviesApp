package com.mudassir.data.gateway

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable

import com.mudassir.data.paging.MovieDataSource
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.entity.MovieEntity
import com.mudassir.domain.gateway.MovieListGateWay
import io.reactivex.Flowable

class MovieListGateWayImpl (private val movieListRepository: MovieListRepository): MovieListGateWay{


    override fun getMovieList(refresh: Boolean?): Flowable<PagingData<MovieEntity>> {
        val pager =  Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 20)){
             MovieDataSource(movieListRepository)
        }.flowable

      return pager

    }

}