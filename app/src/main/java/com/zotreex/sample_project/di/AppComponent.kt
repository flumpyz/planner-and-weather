package com.zotreex.sample_project.di

import com.zotreex.sample_project.ui.fragments.SampleFragment
import com.zotreex.sample_project.ui.fragments.SearchFragment
import com.zotreex.sample_project.ui.fragments.SettingsFragment
import com.zotreex.sample_project.ui.fragments.WeatherInfoFragment
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: SampleFragment)
    fun inject(fragment: WeatherInfoFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: SettingsFragment)

    fun viewModelFactory() : ViewModelFactory
}

@Module(includes = [NetworkModule::class, AppBindModule::class, ViewModelModule::class])
class AppModule
