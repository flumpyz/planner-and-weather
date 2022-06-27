package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("resolvedAddress")
    var cityName: String? = null,

    @SerializedName("days")
    var daysInfo: List<SampleItem>,
)
