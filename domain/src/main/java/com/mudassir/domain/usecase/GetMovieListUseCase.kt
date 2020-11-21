package com.mudassir.domain.usecase

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.UseCase
import com.mudassir.domain.entity.MovieListEntity
import com.mudassir.domain.gateway.MovieListGateWay
import io.reactivex.Single

class GetMovieListUseCase(schedulers: SchedulerProvider,
                          private val getMovieListGateWay: MovieListGateWay)
    : UseCase<Boolean,MovieListEntity>(schedulers){

    override fun buildUseCaseObservable(refresh: Boolean): Single<MovieListEntity> {

        return getMovieListGateWay.getMovieList(refresh)
    }
}