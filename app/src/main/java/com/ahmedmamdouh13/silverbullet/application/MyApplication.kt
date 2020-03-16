package com.ahmedmamdouh13.silverbullet.application

import android.app.Application
import com.ahmedmamdouh13.presentation.di.module
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            this.modules(module)
        }
    }

}