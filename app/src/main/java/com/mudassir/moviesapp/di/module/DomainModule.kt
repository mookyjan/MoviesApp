package com.mudassir.moviesapp.di.module

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.gateway.MovieListGateWay
import com.mudassir.domain.usecase.GetMovieListUseCase
import dagger.Module
import dagger.Provides

@Module
 class DomainModule {
    @Provides
    fun provideDomainModule(schedulerProvider: SchedulerProvider, movieGateWay: MovieListGateWay)
            = GetMovieListUseCase(schedulerProvider,movieGateWay)
}