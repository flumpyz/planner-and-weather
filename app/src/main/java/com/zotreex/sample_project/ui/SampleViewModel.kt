package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.SampleItemList
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCase
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val getSampleListUseCase: GetSampleListUseCase
) : ViewModel() {
    val liveData = MutableLiveData<UiState<SampleItemList>>(UiState.Loading)

    init {
        val currentDate = LocalDateTime.now()
        val nextDate = currentDate.plusDays(5)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentFormattedDate = currentDate.format(formatter)
        val nextFormattedDate = nextDate.format(formatter)

        viewModelScope.launch {
            val list = getSampleListUseCase("Chelyabinsk", currentFormattedDate, nextFormattedDate)
            liveData.postValue(UiState.Success(list))
        }
    }

    fun setLive() {
        val currentDate = LocalDateTime.now()
        val nextDate = currentDate.plusDays(5)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentFormattedDate = currentDate.format(formatter)
        val nextFormattedDate = nextDate.format(formatter)

        viewModelScope.launch {
            val list = getSampleListUseCase("Chelyabinsk", currentFormattedDate, nextFormattedDate)
            liveData.postValue(UiState.Success(list))
        }
    }

}