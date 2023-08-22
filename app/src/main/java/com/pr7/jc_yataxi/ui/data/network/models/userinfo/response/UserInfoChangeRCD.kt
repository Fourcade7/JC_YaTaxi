package com.pr7.jc_yataxi.ui.data.network.models.userinfo.response

data class UserInfoChangeRCD(
    val first_name: String?=null,
    val id: String?=null,
    val last_name: String?=null,
    val passport: String?=null,
    val phone: String?=null,
    val two_step_password: Boolean?=false,
    val user_type: String?=null
)