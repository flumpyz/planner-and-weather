package com.zotreex.sample_project.domain.usecases.getSampleList

import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.SampleItemList

interface GetSampleListUseCase {
    suspend operator fun invoke(cityName: String, dateFrom: String, dateTo: String): SampleItemList
}