package com.zotreex.sample_project.domain.api

import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.SampleItemList
import com.zotreex.sample_project.domain.data.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SampleService {
    @GET("{city}/{dateFrom}/{dateTo}?unitGroup=metric&include=days&key=PE3AAVLTH9AQ9TL65L3UNBGMM&contentType=json")
    suspend fun getWeatherInfoItem(
        @Path("city") city: String,
        @Path("dateFrom") dateFrom: String,
        @Path("dateTo") dateTo: String
    ): WeatherInfo

    @GET("{city}/{dateFrom}/{dateTo}?unitGroup=metric&include=days&key=PE3AAVLTH9AQ9TL65L3UNBGMM&contentType=json")
    suspend fun getWeatherInfoList(
        @Path("city") city: String,
        @Path("dateFrom") dateFrom: String,
        @Path("dateTo") dateTo: String
    ): SampleItemList
}