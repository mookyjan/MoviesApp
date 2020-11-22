package com.mudassir.moviesapp.di.module

import android.app.Application
import android.content.Context
import com.mudassir.domain.SchedulerProvider
import com.mudassir.moviesapp.util.IResourceProvider
import com.mudassir.moviesapp.di.module.scheduler.AppSchedulers
import com.mudassir.moviesapp.ui.list.adapter.MovieListAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    @Named("application.Context")
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideSchedulers() : SchedulerProvider = AppSchedulers()

    @Provides
    @Singleton
    fun provideResource(context: Context) = IResourceProvider(context)

    @Provides
    @Singleton
    fun provideMovieAdapter() = MovieListAdapter()
}