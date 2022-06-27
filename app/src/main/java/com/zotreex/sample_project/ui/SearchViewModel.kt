package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.SampleItemList
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.data.WeatherInfo
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCase
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getSampleListUseCase: GetSampleListUseCase
) : ViewModel() {
    val liveData = MutableLiveData<UiState<SampleItemList>>(UiState.Loading)

    fun search(city: String) {
        val currentDate = LocalDateTime.now()
        val nextDate = currentDate.plusDays(5)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentFormattedDate = currentDate.format(formatter)
        val nextFormattedDate = nextDate.format(formatter)

        viewModelScope.launch {
            try {
                val list = getSampleListUseCase(city, currentFormattedDate, nextFormattedDate)
                liveData.postValue(UiState.Success(list))
            } catch (e: Exception) {
                liveData.postValue(UiState.Error("Не удалось получить данные по вашему запросу"))
            }
        }
    }
}