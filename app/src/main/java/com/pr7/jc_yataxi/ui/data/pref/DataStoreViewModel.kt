package com.pr7.jc_yataxi.ui.data.pref

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DataStoreViewModel constructor(application: Application):AndroidViewModel(application) {

    val dataStoreManager=DataStoreManager(application)
    init {
        viewModelScope.launch {
            val getdata=dataStoreManager.load("firstt").asLiveData(Dispatchers.Main)

        }
    }

}