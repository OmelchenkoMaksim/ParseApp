package com.example.usecasesapp.app

import android.app.Application
import com.example.usecasesapp.di.appModule
import com.example.usecasesapp.di.dataModule
import com.example.usecasesapp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}