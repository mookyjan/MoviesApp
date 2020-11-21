package com.mudassir.moviesapp.di.module

import com.mudassir.moviesapp.ui.list.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun movieListFragment() : MovieListFragment
}