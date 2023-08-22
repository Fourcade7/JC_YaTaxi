package com.pr7.jc_yataxi.ui.data.network.models.verify_otp.response

data class OtpRCD(
    val created: Boolean=false,
    val access: String="",
    val refresh: String="",
    val message:String="",
    val succes:Boolean=false
)