package edu.kabi.live.logic.network

import edu.kabi.live.logic.model.Live
import retrofit2.Call
import retrofit2.http.GET

interface LiveService {
    @GET("live")
    fun getAllLive():Call<List<Live>>



}