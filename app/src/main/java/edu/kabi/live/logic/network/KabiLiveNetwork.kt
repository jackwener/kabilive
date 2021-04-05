package edu.kabi.live.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object KabiLiveNetwork {

    private val liveService = ServiceCreator.create(LiveService::class.java)

    private val sortService = ServiceCreator.create(SortService::class.java)

    suspend fun getAllLive() = liveService.getAllLive().await()

    suspend fun getAllSort() = sortService.getAllSort().await()

//    suspend fun getRealtimeWeather(lng: String, lat: String) = weatherService.getRealtimeWeather(lng, lat).await()
//
//    private val userService = ServiceCreator.create(UserService::class.java)
//
//    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    if (response.code() != 200) {
                        continuation.resumeWithException(RuntimeException("response code isn't 200"))
                    }
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}