package com.zotreex.sample_project.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor(

) : ViewModel() {
    val liveData = MutableLiveData<Int>(0)

    fun setTheme(id: Int) {
        liveData.postValue(id)
    }
}