package com.example.parsingapp.data

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Main Retrofit Service
 * */
interface NavvisService {

    /**
     * Fetch range of ints
     */
    @GET("numbers.json")
    suspend fun fetch(): ResponseBody
}