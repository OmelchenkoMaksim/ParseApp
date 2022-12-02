package com.example.parsingapp.di

import com.example.parsingapp.data.CloudDataSourceImpl
import com.example.parsingapp.data.CloudDataSourceMock
import com.example.parsingapp.data.NavvisService
import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.data.models.ListBinariesForUI
import com.example.parsingapp.data.repository.RepositoryImpl
import com.example.parsingapp.domain.repository.BaseRepository
import com.example.parsingapp.domain.repository.CloudDataSource
import com.google.gson.Gson
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

// use true if backend is ready
private const val isRelease = false

val dataModule = module {

    single<Retrofit> { provideRetrofit() }

    single { Gson() }

    single<NavvisService> { provideService(retrofit = get()) }

    single<CloudDataSource<CloudModel>> {
        if (isRelease) {
            CloudDataSourceImpl(service = get(), gson = get())
        } else {
            CloudDataSourceMock()
        }
    }

    single<BaseRepository<ListBinariesForUI>> { RepositoryImpl(cloudDataSource = get()) }
}

private fun provideRetrofit() = Retrofit.Builder().baseUrl(BASE_URL).build()

private fun provideService(retrofit: Retrofit): NavvisService = retrofit.create()

private const val BASE_URL = "http://navvis.com"