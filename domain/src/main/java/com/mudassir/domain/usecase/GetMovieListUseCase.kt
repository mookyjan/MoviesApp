package com.mudassir.domain.usecase

import androidx.paging.PagingData
import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.UseCase
import com.mudassir.domain.entity.MovieEntity
import com.mudassir.domain.gateway.MovieListGateWay
import io.reactivex.Flowable

class GetMovieListUseCase(schedulers: SchedulerProvider,
                          private val getMovieListGateWay: MovieListGateWay)
    : UseCase<Boolean,PagingData<MovieEntity>>(schedulers){



    override fun buildUseCaseObservable(refresh: Boolean): Flowable<PagingData<MovieEntity>> {

        return getMovieListGateWay.getMovieList(refresh)
    }
}