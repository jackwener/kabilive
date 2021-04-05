package edu.kabi.live.ui.sort

import androidx.lifecycle.ViewModel
import edu.kabi.live.logic.Repository

class SortViewModel : ViewModel() {

    val sortList = ArrayList<String>()

    val sortLiveData =  Repository.getAllSort()


}