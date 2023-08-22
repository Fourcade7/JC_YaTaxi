package com.pr7.jc_yataxi.ui.screens.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_yataxi.ui.data.network.models.register.request.RegisterCD
import com.pr7.jc_yataxi.ui.data.network.models.register.response.RegisterRCD
import com.pr7.jc_yataxi.ui.data.network.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class RegisterViewModel constructor():ViewModel() {

    //reg
    val api=RetrofitInstance.api
    val mlivedataRegisterRCD=MutableLiveData<RegisterRCD>()
    val completed=MutableLiveData<Boolean>()
    val succes=MutableLiveData<Boolean>(false)




    fun registerCD(registerCD: RegisterCD)=viewModelScope.launch{
        completed.postValue(false)
        try {
            val regresponse=api.registerCD(registerCD = registerCD)
            mlivedataRegisterRCD.postValue(regresponse)
            succes.postValue(true)

        }catch (e:Exception){
            mlivedataRegisterRCD.postValue(RegisterRCD(phone = listOf("error"), succes = false))
            succes.postValue(false)

        }
        completed.postValue(true)
    }






}