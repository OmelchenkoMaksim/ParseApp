package com.example.parsingapp.di

import com.example.data.BuildConfig
import com.example.parsingapp.data.CloudDataSourceImpl
import com.example.parsingapp.data.CloudDataSourceMock
import com.example.parsingapp.data.RetroService
import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.data.models.ListBinariesForUI
import com.example.parsingapp.data.repository.RepositoryImpl
import com.example.parsingapp.domain.repository.BaseRepository
import com.example.parsingapp.domain.repository.CloudDataSource
import com.google.gson.Gson
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val dataModule = module {

    single<Retrofit> { provideRetrofit() }

    single { Gson() }

    single<RetroService> { provideService(retrofit = get()) }

    single<CloudDataSource<CloudModel>> {
        if (BuildConfig.DEBUG) {
            CloudDataSourceMock()
        } else {
            CloudDataSourceImpl(service = get(), gson = get())
        }
    }

    single<BaseRepository<ListBinariesForUI>> { RepositoryImpl(cloudDataSource = get()) }
}

private fun provideRetrofit() = Retrofit.Builder().baseUrl(BASE_URL).build()

private fun provideService(retrofit: Retrofit): RetroService = retrofit.create()

private const val BASE_URL = "http://site.com"