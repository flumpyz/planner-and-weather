package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.SampleItemList

interface SampleRepository {
    suspend fun getSampleList(
        cityName: String,
        dateFrom: String,
        dateTo: String
    ): SampleItemList

    suspend fun getSampleItem(
        cityName: String,
        date: String
    ): SampleItem
}