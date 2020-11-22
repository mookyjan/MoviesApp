package com.mudassir.moviesapp

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.mudassir.moviesapp.di.component.AppComponent
import com.mudassir.moviesapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MovieApp : Application(), HasAndroidInjector {


    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = activityDispatchingAndroidInjector

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        component = DaggerAppComponent
            .builder()
            .application(this)
            .context(this)
            .build()
        component.inject(this)
    }

}