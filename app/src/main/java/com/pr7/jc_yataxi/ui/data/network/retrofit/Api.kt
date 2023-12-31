package com.pr7.jc_yataxi.ui.data.network.retrofit

import com.pr7.jc_yataxi.ui.data.network.models.directions.DirectionsR
import com.pr7.jc_yataxi.ui.data.network.models.district.response.DistrictR
import com.pr7.jc_yataxi.ui.data.network.models.ferfesh_token.request.FerFeshToken
import com.pr7.jc_yataxi.ui.data.network.models.ferfesh_token.response.FerFeshTokenR
import com.pr7.jc_yataxi.ui.data.network.models.login.request.LoginCD
import com.pr7.jc_yataxi.ui.data.network.models.login.response.LoginRCD
import com.pr7.jc_yataxi.ui.data.network.models.regions.response.RegionsR
import com.pr7.jc_yataxi.ui.data.network.models.register.request.RegisterCD
import com.pr7.jc_yataxi.ui.data.network.models.register.response.RegisterRCD
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.request.UserInfoChangeCD
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.network.models.verify_otp.request.OtpCD
import com.pr7.jc_yataxi.ui.data.network.models.verify_otp.response.OtpRCD
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    //http://yataxi.testing.uz/users/api/register/
    @POST("en/users/api/register/")
    suspend fun registerCD(@Body registerCD: RegisterCD): RegisterRCD

    //http://yataxi.testing.uz/users/api/verify/
    @POST("en/users/api/verify/")
    suspend fun verifyotpCD(@Body otpCD: OtpCD): OtpRCD

    //http://yataxi.testing.uz/users/api/login/
    @POST("en/users/api/login/")
    suspend fun loginCD(@Body loginCD: LoginCD): Response<LoginRCD>

    //https://yataxi.testing.uz/users/api/profile/

    @GET("en/users/api/profile/")
    suspend fun getUserInfo(@Header("Authorization") token :String):UserInfoChangeRCD

    //https://yataxi.testing.uz/users/api/profile/
    @PUT("en/users/api/profile/")
    suspend fun changeUserInfo(
        @Header("Authorization") token :String,
        @Body userInfoChangeCD: UserInfoChangeCD
    ):UserInfoChangeRCD

    //https://yataxi.testing.uz/map/region-list/
    @GET("en/map/region-list/")
    suspend fun getAllRegions(@Header("Authorization") token :String):ArrayList<RegionsR>


    //https://yataxi.testing.uz/en/map/district-list/4/
    @GET("en/map/district-list/{id}/")
    suspend fun getDisrict(
        @Header("Authorization") token :String,
        @Path("id") id:Int
    ):ArrayList<DistrictR>


    @POST("en/users/api/refresh-token/")
    suspend fun getnewFerfesh(
        @Header("Authorization") ferFeshToken: FerFeshToken,
    ):FerFeshTokenR


    //https://yataxi.testing.uz/en/taxi/direction-list/?from_district=62&from_region=4&to_district=205&to_region=14
    @GET("en/taxi/direction-list/")
    suspend fun getDriversList(
        @Header("Authorization") token :String,
        @Query("from_district") fromdisid:Int,
        @Query("to_district") todisid:Int,
        @Query("from_region") fromregid:Int,
        @Query("to_region") toregid:Int,
    ):ArrayList<DirectionsR>




}