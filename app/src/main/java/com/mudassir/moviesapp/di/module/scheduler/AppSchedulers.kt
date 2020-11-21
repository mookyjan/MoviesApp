package com.mudassir.moviesapp.di.module.scheduler

import com.mudassir.domain.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppSchedulers : SchedulerProvider {

    override val subscribeOn: Scheduler
        get() = Schedulers.io()
    override val observeOn: Scheduler
        get() = AndroidSchedulers.mainThread()
    override val newThread: Scheduler
        get() = Schedulers.newThread()
}