package com.mudassir.moviesapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.PagingData
import com.github.ajalt.timberkt.Timber
import com.mudassir.data.remote.model.MovieModel
import com.mudassir.domain.entity.MovieEntity
import com.mudassir.domain.usecase.GetMovieListUseCase
import com.mudassir.moviesapp.base.BaseViewModel
import com.mudassir.moviesapp.model.Movie
import com.mudassir.moviesapp.model.mapToPresentation
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) : BaseViewModel() {

    private val _movieList = MutableLiveData<PagingData<Movie>>()
    var movieList: LiveData<PagingData<Movie>> = _movieList

    fun getMovieList(isRefresh:Boolean =true){
        _loading.postValue(true)
        getMovieListUseCase.execute(isRefresh)
            .subscribeBy(onNext = {
                _loading.postValue(false)
                _movieList.postValue( it.map {
                    it.mapToPresentation()
                })
                Timber.d { "movie list api response $it" }
            },onError = {e->
                _loading.postValue(false)
                _error.postValue(e.localizedMessage ?: e.message ?:"Unknown error")
                Timber.e { "error on movie list api ${e.printStackTrace()}" }
            },onComplete = {
                _loading.postValue(false)
            }).addTo(compositeDisposable)

    }

    /**
     * refresh the list
     */
    fun refresh() = getMovieList(true)
}