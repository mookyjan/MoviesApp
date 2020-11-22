package com.mudassir.domain.usecase

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.SingleUseCase
import com.mudassir.domain.entity.MovieDetailEntity
import com.mudassir.domain.gateway.MovieDetailGateWay
import io.reactivex.Single

class GetMovieDetailUseCase(
    schedulers: SchedulerProvider,
    private val getMovieDetailGateWay: MovieDetailGateWay
) : SingleUseCase<Int, MovieDetailEntity>(schedulers) {

    override fun buildUseCaseObservable(movieId: Int): Single<MovieDetailEntity> {

        return getMovieDetailGateWay.getMovieDetail(movieId)
    }
}
