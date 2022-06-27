package com.zotreex.sample_project.domain.usecases.getSampleItem

import com.zotreex.sample_project.domain.data.WeatherInfo

interface GetSampleItemUseCase {
    suspend operator fun invoke(cityName: String, dateFrom: String, dateTo:String): WeatherInfo
}