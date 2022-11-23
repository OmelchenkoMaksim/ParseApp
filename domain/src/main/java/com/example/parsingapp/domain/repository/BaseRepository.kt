package com.example.parsingapp.domain.repository

/**
 * Main repository
 */
interface BaseRepository<T> {
    suspend fun fetch(): T
}