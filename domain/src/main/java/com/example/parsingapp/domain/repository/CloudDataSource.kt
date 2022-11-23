package com.example.parsingapp.domain.repository

/**
 * Main interface for fetch data logic
 */
interface CloudDataSource<T> {

    suspend fun fetch(): T
}