package com.zotreex.sample_project.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zotreex.sample_project.ui.viewModels.SampleViewModel
import com.zotreex.sample_project.ui.viewModels.SearchViewModel
import com.zotreex.sample_project.ui.viewModels.SettingsViewModel
import com.zotreex.sample_project.ui.viewModels.WeatherInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    abstract fun sampleViewModel(sampleViewModel: SampleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel::class)
    abstract fun weatherInfoViewModel(weatherInfoViewModel: WeatherInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun searchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun settingsViewModel(settingsViewModel: SettingsViewModel): ViewModel
}