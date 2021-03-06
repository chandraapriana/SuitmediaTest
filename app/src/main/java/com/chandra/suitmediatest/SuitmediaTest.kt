package com.chandra.suitmediatest

import android.app.Application
import com.chandra.suitmediatest.ui.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SuitmediaTest : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SuitmediaTest)
            modules(appModule)
        }
    }
}