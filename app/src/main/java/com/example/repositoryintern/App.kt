package com.example.repositoryintern

import android.app.Application
import com.example.repositoryintern.di.AppComponent
import com.example.repositoryintern.di.AppModule
import com.example.repositoryintern.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}