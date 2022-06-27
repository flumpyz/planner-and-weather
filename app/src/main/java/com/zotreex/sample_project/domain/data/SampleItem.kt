package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class SampleItem(
    @SerializedName("datetime")
    var datetime : String? = null,

    @SerializedName("temp")
    var temperature : Float? = null,

    @SerializedName("tempmin")
    var minTemperature : Double? = null,

    @SerializedName("tempmax")
    var maxTemperature : Double? = null,

    @SerializedName("feelslike")
    var feelsLike : Float? = null,

    @SerializedName("humidity")
    var humidity : Float? = null,

    @SerializedName("windspeed")
    var windSpeed : Float? = null,

    @SerializedName("pressure")
    var pressure : Float? = null,

    @SerializedName("conditions")
    var conditions : String? = null,

    @SerializedName("icon")
    var icon : String? = null,
)
