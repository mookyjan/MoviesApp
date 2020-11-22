package com.mudassir.moviesapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.Timber
import com.mudassir.domain.usecase.GetMovieDetailUseCase
import com.mudassir.moviesapp.base.BaseViewModel
import com.mudassir.moviesapp.mapper.MovieDetailDomainToPresentation
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    BaseViewModel() {

    val movieId = MutableLiveData<Int>(0)
    var _movieDetail = MutableLiveData<MovieDetailModel>()
    val movieDetail: LiveData<MovieDetailModel> = _movieDetail

    fun getMovieDetail(movieId: Int) {
        _loading.postValue(true)
        getMovieDetailUseCase.execute(movieId)
            .subscribeBy(onSuccess = {
                _loading.postValue(false)
                _movieDetail.postValue(MovieDetailDomainToPresentation.transformTo(it))
                Timber.d { "movie Detail api success" }
            }, onError = { e ->
                _loading.postValue(false)
                _error.postValue("Unknown error")
                Timber.e { "error movie detail ${e.printStackTrace()}" }

            }).addTo(compositeDisposable)
    }
}