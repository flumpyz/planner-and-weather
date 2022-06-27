package com.zotreex.sample_project.domain.usecases.getSampleItem

import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.WeatherInfo
import com.zotreex.sample_project.domain.repository.SampleRepository
import javax.inject.Inject

class GetSampleItemUseCaseImpl @Inject constructor(
    private val sampleRepository: SampleRepository
) : GetSampleItemUseCase {
    override suspend fun invoke(cityName: String, dateFrom: String, dateTo: String): WeatherInfo =
        sampleRepository.getSampleItem(cityName, dateFrom, dateTo)
}