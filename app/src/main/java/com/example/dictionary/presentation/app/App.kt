package com.example.dictionary.presentation.app

import android.app.Application
import com.example.dictionary.presentation.di.dataModule
import com.example.dictionary.presentation.di.domainModule
import com.example.dictionary.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}