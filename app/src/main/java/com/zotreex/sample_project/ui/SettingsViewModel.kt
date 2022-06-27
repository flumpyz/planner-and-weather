package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zotreex.sample_project.domain.data.SampleItemList
import com.zotreex.sample_project.domain.data.UiState
import javax.inject.Inject

class SettingsViewModel @Inject constructor(

) : ViewModel() {
    val liveData = MutableLiveData<Int>(0)

    fun setTheme(id: Int) {
        liveData.postValue(id)
    }
}