package com.zotreex.sample_project

import android.app.Application
import com.zotreex.sample_project.di.AppComponent
import com.zotreex.sample_project.di.DaggerAppComponent

class MainApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}