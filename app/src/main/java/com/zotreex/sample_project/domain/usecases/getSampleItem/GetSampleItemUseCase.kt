package com.zotreex.sample_project.domain.usecases.getSampleItem

import com.zotreex.sample_project.domain.data.SampleItem

interface GetSampleItemUseCase {
    suspend operator fun invoke(cityName: String, date: String): SampleItem
}