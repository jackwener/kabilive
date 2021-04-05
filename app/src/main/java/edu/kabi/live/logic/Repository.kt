package edu.kabi.live.logic

import androidx.lifecycle.liveData
import edu.kabi.live.logic.network.KabiLiveNetwork
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object Repository {
    fun getAllLive() = fire(Dispatchers.IO) {
        val liveResponse = KabiLiveNetwork.getAllLive()
        Result.success(liveResponse)
    }

    fun getAllSort() = fire(Dispatchers.IO) {
        val sortResponse = KabiLiveNetwork.getAllSort()
        Result.success(sortResponse)
    }

//    fun getAllLive() = fire(Dispatchers.IO) {
//        KabiLiveNetwork.getAllLive()
//    }


//    private fun <T> fire(context: CoroutineContext, block: suspend () -> T) =
//        liveData<T>(context) {
//            emit(block())
//        }
    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}