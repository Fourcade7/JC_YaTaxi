package com.pr7.jc_yataxi.ui.data.network.models.login.response

data class LoginRCD(
    val otp: String?=null,
    val message:String="",
    val statuscode:Int=0

)