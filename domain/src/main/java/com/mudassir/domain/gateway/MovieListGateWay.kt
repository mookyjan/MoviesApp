package com.mudassir.domain.gateway

import androidx.paging.PagingData
import com.mudassir.domain.entity.MovieEntity
import io.reactivex.Flowable

interface MovieListGateWay {

    fun getMovieList(refresh: Boolean? = false): Flowable<PagingData<MovieEntity>>
}