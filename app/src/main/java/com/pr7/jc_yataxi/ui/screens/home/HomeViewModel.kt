package com.pr7.jc_yataxi.ui.screens.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.jc_yataxi.ui.data.network.models.directions.DirectionsR
import com.pr7.jc_yataxi.ui.data.network.models.district.response.DistrictR
import com.pr7.jc_yataxi.ui.data.network.models.ferfesh_token.request.FerFeshToken
import com.pr7.jc_yataxi.ui.data.network.models.ferfesh_token.response.FerFeshTokenR
import com.pr7.jc_yataxi.ui.data.network.models.regions.response.RegionsR
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.network.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel constructor(): ViewModel() {

    //userinfo
    val api= RetrofitInstance.api
    val mlivedatagetUserInfoRCD= MutableLiveData<UserInfoChangeRCD>()
    val completed= MutableLiveData<Boolean>()
    val succes= MutableLiveData<Boolean>(false)

    //regions
    val mlivedataAllRegionsCD= MutableLiveData<ArrayList<RegionsR>>()
    val completedreg= MutableLiveData<Boolean>()
    val succesreg= MutableLiveData<Boolean>(false)

    //district

    //regions
    val mlivedataAllDistrictRCD= MutableLiveData<ArrayList<DistrictR>>()
    val completeddis= MutableLiveData<Boolean>()
    val succesdis= MutableLiveData<Boolean>(false)

    val districtchoose=MutableLiveData<String>(null)
    val districtfrom=MutableLiveData<String>("Select Your Location")
    val districtto=MutableLiveData<String>("Select Your Location")

    //new district
    val regfromid=MutableLiveData<Int>(null)
    val regtoid=MutableLiveData<Int>(null)
    val disfromid=MutableLiveData<Int>(null)
    val distoid=MutableLiveData<Int>(null)
    val mlivedataAllDrivers=MutableLiveData<ArrayList<DirectionsR>>()
    val completeddrivers= MutableLiveData<Boolean>()
    val succesdrivers= MutableLiveData<Boolean>(false)

    //ferfreshtoken
    //regions
    val mlivedataFerFeshToken= MutableLiveData<FerFeshTokenR>()
    val completedref= MutableLiveData<Boolean>()
    val succesref= MutableLiveData<Boolean>(false)
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
            Log.d("PR77777", "getAllRegions: ${e.message}")

        }
        completedreg.postValue(true)
    }


    fun getDistrictCD(token:String,id:Int)=viewModelScope.launch{
        completeddis.postValue(false)
        try {
            val regresponse=api.getDisrict("Bearer $token",id=id)
            mlivedataAllDistrictRCD.postValue(regresponse)
            succesdis.value=true

        }catch (e:Exception){
            mlivedataAllDistrictRCD.postValue(ArrayList<DistrictR>())
            succesdis.value=false
            Log.d("PR77777", "getDistrict: ${e.message}")

        }
        completeddis.postValue(true)
    }

    fun getnewFerfesh(token:String)=viewModelScope.launch{
        completedref.postValue(false)
        try {
            val regresponse=api.getnewFerfesh(FerFeshToken(refresh = token))
            mlivedataFerFeshToken.postValue(regresponse)
            succesref.value=true

        }catch (e:Exception){
            mlivedataFerFeshToken.postValue(FerFeshTokenR(null))
            succesref.value=false
            Log.d("PR77777", "getnewToken: ${e.message}")

        }
        completedref.postValue(true)
    }

    fun getdistricttaxi(token :String, fromdisid:Int, todisid :Int, fromregid :Int, toregid :Int)=viewModelScope.launch {
        completeddrivers.postValue(false)
        try {
            val response=api.getDriversList("Bearer $token" ,fromdisid , todisid, fromregid, toregid)
            mlivedataAllDrivers.postValue(response)
            succesdrivers.postValue(true)

        }catch (e:Exception){
            succesdrivers.postValue(false)


        }
        completeddrivers.postValue(true)

    }


}