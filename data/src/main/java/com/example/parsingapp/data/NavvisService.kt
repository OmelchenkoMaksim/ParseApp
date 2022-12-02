package com.example.parsingapp.data

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Main Retrofit Service
 * */
interface NavvisService {

    /**
     * Fetch range of ints
     * for example this json:

    {
    "numbers": [
    4, 150, 12, 21, 136, 16, 3
    ]
    }

     */
    @GET("numbers.json")
    suspend fun fetch(): ResponseBody
}