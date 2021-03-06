package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.api.SampleService
import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.SampleItemList
import com.zotreex.sample_project.domain.data.WeatherInfo
import kotlinx.coroutines.delay
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val sampleService: SampleService
) : SampleRepository {
    override suspend fun getSampleList(
        cityName: String,
        dateFrom: String,
        dateTo: String
    ): SampleItemList {
        return sampleService.getWeatherInfoList(cityName, dateFrom, dateTo)
    }

    override suspend fun getSampleItem(
        cityName: String,
        dateFrom: String,
        dateTo: String
    ): WeatherInfo = sampleService.getWeatherInfoItem(cityName, dateFrom, dateTo)
}