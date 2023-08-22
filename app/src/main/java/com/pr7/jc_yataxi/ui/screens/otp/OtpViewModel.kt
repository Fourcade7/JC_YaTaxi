package com.pr7.jc_yataxi.ui.screens.otp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_yataxi.ui.data.network.models.verify_otp.request.OtpCD
import com.pr7.jc_yataxi.ui.data.network.models.verify_otp.response.OtpRCD
import com.pr7.jc_yataxi.ui.data.network.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class OtpViewModel constructor(): ViewModel() {


    val api= RetrofitInstance.api
    val mlivedataOtpRCD= MutableLiveData<OtpRCD>()
    val completed= MutableLiveData<Boolean>()
    val succes= MutableLiveData<Boolean>(false)


    fun verifyotp(otpCD: OtpCD)=viewModelScope.launch {
        completed.postValue(false)
        try {
            val responseotp=api.verifyotpCD(otpCD = otpCD)
            mlivedataOtpRCD.postValue(responseotp)
            succes.postValue(true)
        }catch (e:Exception){
            succes.postValue(false)
        }
        completed.postValue(true)

    }

}