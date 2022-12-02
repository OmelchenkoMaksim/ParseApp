package com.example.parsingapp.data

import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.domain.repository.CloudDataSource

class CloudDataSourceMock : CloudDataSource<CloudModel> {

    override suspend fun fetch() = CloudModel(listOf<Int>(2, 1, 44, 2, 17, 33))
}