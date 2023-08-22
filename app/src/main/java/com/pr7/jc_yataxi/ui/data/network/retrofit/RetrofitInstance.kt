package com.pr7.jc_yataxi.ui.data.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {

//    var okHttpClient = OkHttpClient().newBuilder()
//        .connectTimeout(60, TimeUnit.SECONDS)
//        .readTimeout(60, TimeUnit.SECONDS)
//        .writeTimeout(60, TimeUnit.SECONDS)
//        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://yataxi.testing.uz/")
        .addConverterFactory(GsonConverterFactory.create())
        //.client(okHttpClient)
        .build()

    val api= retrofit.create(Api::class.java)!!
}