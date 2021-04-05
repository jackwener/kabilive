package edu.kabi.live.ui.live

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import edu.kabi.live.logic.Repository
import edu.kabi.live.logic.model.Live

class LiveViewModel : ViewModel() {

    private val liveLiveData = MutableLiveData<List<Live>>()

    val liveList = ArrayList<Live>()

    val liveGetLiveData =  Repository.getAllLive()




}