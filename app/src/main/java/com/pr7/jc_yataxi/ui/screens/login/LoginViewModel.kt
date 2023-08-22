package com.pr7.jc_yataxi.ui.screens.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_yataxi.ui.data.network.models.login.request.LoginCD
import com.pr7.jc_yataxi.ui.data.network.models.login.response.LoginRCD
import com.pr7.jc_yataxi.ui.data.network.models.register.request.RegisterCD
import com.pr7.jc_yataxi.ui.data.network.models.register.response.RegisterRCD
import com.pr7.jc_yataxi.ui.data.network.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class LoginViewModel constructor(): ViewModel() {

    //reg
    val api= RetrofitInstance.api
    val mlivedataLoginRCD= MutableLiveData<LoginRCD>()
    val completed= MutableLiveData<Boolean>()
    val succes= MutableLiveData<Boolean>(null)




    fun loginrCD(loginCD: LoginCD)=viewModelScope.launch{
        completed.postValue(false)
        try {
            val regresponse=api.loginCD(loginCD = loginCD)
            val loginRCD=regresponse.body()
            mlivedataLoginRCD.postValue(LoginRCD(loginRCD?.otp, loginRCD!!.message,regresponse.code()))
            succes.postValue(true)

        }catch (e:Exception){
            mlivedataLoginRCD.postValue(LoginRCD(message = e.message.toString()))
            succes.postValue(false)

        }
        completed.postValue(true)
    }






}