package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.api.SampleService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
class NetworkModule {
    @Provides
    fun provideSampleApi(): SampleService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/")
            .client(client)
            .build()
        return retrofit.create()
    }
}