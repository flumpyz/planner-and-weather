package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.SampleItemList
import com.zotreex.sample_project.domain.data.WeatherInfo

interface SampleRepository {
    suspend fun getSampleList(
        cityName: String,
        dateFrom: String,
        dateTo: String
    ): SampleItemList

    suspend fun getSampleItem(
        cityName: String,
        dateFrom: String,
        dateTo: String
    ): WeatherInfo
}