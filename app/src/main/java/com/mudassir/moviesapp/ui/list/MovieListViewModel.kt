package com.mudassir.moviesapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.PagingData
import androidx.paging.map
import androidx.paging.rxjava2.cachedIn
import com.github.ajalt.timberkt.Timber
import com.mudassir.data.gateway.MovieListGateWayImpl
import com.mudassir.data.remote.model.MovieModel
import com.mudassir.data.repository.MovieListRepository
import com.mudassir.domain.entity.MovieEntity
import com.mudassir.domain.usecase.GetMovieListUseCase
import com.mudassir.moviesapp.base.BaseViewModel
import com.mudassir.moviesapp.model.Movie
import com.mudassir.moviesapp.model.mapToPresentation
import io.reactivex.Flowable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) : BaseViewModel() {

    private val _movieList = MutableLiveData<PagingData<Movie>>()
    var movieList: LiveData<PagingData<Movie>> = _movieList


    fun getMovieList(isRefresh:Boolean =true) : Flowable<PagingData<Movie>>{
        val result = getMovieListUseCase.execute(isRefresh)

            .map { it.map { it.mapToPresentation() } }
            .cachedIn(viewModelScope)

        return result
    }

    /**
     * refresh the list
     */
    fun refresh() = getMovieList(true)
}