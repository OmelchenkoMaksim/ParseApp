package com.example.parsingapp.data

import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.domain.repository.CloudDataSource

class CloudDataSourceMock : CloudDataSource<CloudModel> {

    override suspend fun fetch() = CloudModel(mockList)

    private companion object {
        private val mockList = listOf<Int>(2, 1, 44, 2, 17, 33, 100, 999, 0)
    }
}