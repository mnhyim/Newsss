package com.mnhyim.newsss

import android.app.Application
import com.mnhyim.newsss.di.dataModule
import com.mnhyim.newsss.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                dataModule,
                networkModule
            )
        }
    }
}