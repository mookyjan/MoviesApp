package com.mudassir.moviesapp.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

abstract class BaseViewModel : ViewModel(){

    val compositeDisposable = CompositeDisposable()
    //variable for loading progress
    val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    //variable for error message
    val _error = MutableLiveData<String>()
    val error : LiveData<String>
        get() = _error
    val empty = ObservableBoolean(true)

    fun addDisposable(disposable: Disposable){
        compositeDisposable += disposable
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}