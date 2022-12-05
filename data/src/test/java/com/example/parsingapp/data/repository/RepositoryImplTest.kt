package com.example.parsingapp.data.repository

import com.example.parsingapp.data.models.CloudModel
import com.example.parsingapp.data.repository.RepositoryImpl.Companion.OUT_SECTION
import com.example.parsingapp.domain.repository.CloudDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RepositoryImplTest {

    private val cloudDataSourceMock = CloudDataSourceTest()
    private lateinit var repositoryImpl: RepositoryImpl

    @BeforeEach
    fun beforeEach() {
        repositoryImpl = RepositoryImpl(cloudDataSourceMock)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test for list size after fetch`() = runTest {
        val testList = repositoryImpl.fetch()
        val expectedListSize = 9
        Assertions.assertEquals(expectedListSize, testList.binaries.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test for out of range elements`() = runTest {
        val testList = repositoryImpl.fetch()
        val countOfOutOfRangeElements = testList.binaries.count {
            it.section == OUT_SECTION
        }
        val expectedOutOfRangeElements = 1
        Assertions.assertEquals(expectedOutOfRangeElements, countOfOutOfRangeElements)
    }

    private class CloudDataSourceTest : CloudDataSource<CloudModel> {

        override suspend fun fetch() = CloudModel(mockList)

        companion object {
            private val mockList = listOf<Int>(2, 1, 44, 2, 17, 33, 100, 999, 0)
        }
    }
}