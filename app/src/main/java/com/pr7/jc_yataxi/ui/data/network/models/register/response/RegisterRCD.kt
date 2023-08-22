package com.pr7.jc_yataxi.ui.data.network.models.register.response

data class RegisterRCD(
    val otp: String="",
    val detail:String="",
    val code:String="",
    val phone: List<String> = listOf("succes"),
    val succes:Boolean = true
)