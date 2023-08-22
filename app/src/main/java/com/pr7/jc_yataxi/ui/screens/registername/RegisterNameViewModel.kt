package com.pr7.jc_yataxi.ui.screens.registername

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.request.UserInfoChangeCD
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.network.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class RegisterNameViewModel  constructor(): ViewModel() {

    //reg
    val api= RetrofitInstance.api
    val mlivedatagetUserInfoRCD= MutableLiveData<UserInfoChangeRCD>()
    val completed= MutableLiveData<Boolean>()
    val succes= MutableLiveData<Boolean>(false)




    fun changeUserIinfoCD(token:String,userInfoChangeCD: UserInfoChangeCD)=viewModelScope.launch{
        completed.postValue(false)
        try {
            val regresponse=api.changeUserInfo("Bearer $token",userInfoChangeCD)
            mlivedatagetUserInfoRCD.postValue(regresponse)
            succes.postValue(true)

        }catch (e:Exception){
            mlivedatagetUserInfoRCD.postValue(UserInfoChangeRCD())
            succes.postValue(false)
            Log.d("PR77777", "getUserIinfoCD: ${e.message}")

        }
        completed.postValue(true)
    }


}