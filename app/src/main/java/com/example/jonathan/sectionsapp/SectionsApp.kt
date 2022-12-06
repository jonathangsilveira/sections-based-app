package com.example.jonathan.sectionsapp

import android.app.Application
import com.example.jonathan.data.di.dataModule
import com.example.jonathan.sectionsapp.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SectionsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SectionsApp)
            modules(dataModule, homeModule)
        }
    }
}