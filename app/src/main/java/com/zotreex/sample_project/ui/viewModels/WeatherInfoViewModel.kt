package com.zotreex.sample_project.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.data.WeatherInfo
import com.zotreex.sample_project.domain.usecases.getSampleItem.GetSampleItemUseCase
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class WeatherInfoViewModel @Inject constructor(
    private val getSampleItemUseCase: GetSampleItemUseCase
) : ViewModel() {
    val liveData = MutableLiveData<UiState<WeatherInfo>>(UiState.Loading)

    fun getWeatherInfo(date: String) {
        viewModelScope.launch {
            val list = getSampleItemUseCase("Chelyabinsk", date, date)
            liveData.postValue(UiState.Success(list))
        }
    }
}