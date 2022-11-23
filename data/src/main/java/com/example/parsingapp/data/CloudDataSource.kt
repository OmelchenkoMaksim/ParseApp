package com.example.parsingapp.data

import android.util.Log
import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.domain.repository.CloudDataSource
import com.google.gson.Gson

class CloudDataSourceImpl(
    private val service: NavvisService,
    private val gson: Gson,
) : CloudDataSource<CloudModel> {

    override suspend fun fetch(): CloudModel {
        return try {
            gson.fromJson(service.fetch().string(), CloudModel::class.java)
        } catch (e: Exception) {
            Log.e("fetch exception", e.toString())
            CloudModel(listOf())
        }
    }

}