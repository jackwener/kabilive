package edu.kabi.live.logic.network

import retrofit2.Call
import retrofit2.http.GET

interface SortService {
    @GET("live/sorts")
    fun getAllSort(): Call<List<String>>
}