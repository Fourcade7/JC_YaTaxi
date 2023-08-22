package com.pr7.jc_yataxi.ui.screens.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_yataxi.ui.data.network.models.regions.response.RegionsR
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.network.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel constructor(): ViewModel() {

    //reg
    val api= RetrofitInstance.api
    val mlivedatagetUserInfoRCD= MutableLiveData<UserInfoChangeRCD>()
    val completed= MutableLiveData<Boolean>()
    val succes= MutableLiveData<Boolean>(false)

    val mlivedataAllRegionsCD= MutableLiveData<ArrayList<RegionsR>>()
    val completedreg= MutableLiveData<Boolean>()
    val succesreg= MutableStateFlow(false)




    fun getUserIinfoCD(token:String)=viewModelScope.launch{
        completed.postValue(false)
        try {
            val regresponse=api.getUserInfo("Bearer $token")
            mlivedatagetUserInfoRCD.postValue(regresponse)
            succes.postValue(true)

        }catch (e:Exception){
            mlivedatagetUserInfoRCD.postValue(UserInfoChangeRCD())
            succes.postValue(false)
            Log.d("PR77777", "getUserIinfoCD: ${e.message}")

        }
        completed.postValue(true)
    }

    fun getAllRegionsCD(token:String)=viewModelScope.launch{
        completedreg.postValue(false)
        try {
            val regresponse=api.getAllRegions("Bearer $token")
            mlivedataAllRegionsCD.postValue(regresponse)
            succesreg.value=true

        }catch (e:Exception){
            mlivedataAllRegionsCD.postValue(ArrayList<RegionsR>())
            succesreg.value=false
            Log.d("PR77777", "getUserIinfoCD: ${e.message}")

        }
        completedreg.postValue(true)
    }


}