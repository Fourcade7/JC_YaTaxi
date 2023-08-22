package com.pr7.jc_yataxi.ui.data.pref

import android.content.SharedPreferences
import androidx.activity.ComponentActivity


fun ComponentActivity.saveOnboard(completed:Boolean?) {
    val editor = getSharedPreferences("Pr",
        ComponentActivity.MODE_PRIVATE
    ).edit() as SharedPreferences.Editor
    editor.putBoolean("pr", completed!!)
    editor.commit()
}

fun ComponentActivity.loadOnboard():Boolean {
    val sharedPreferences = getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getBoolean("pr", false)

}


fun ComponentActivity.saveToken(token:String) {
    val editor = getSharedPreferences("Pr",
        ComponentActivity.MODE_PRIVATE
    ).edit() as SharedPreferences.Editor
    editor.putString("accestoken", token!!)
    editor.commit()

}

fun ComponentActivity.loadToken():String? {
    val sharedPreferences = getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getString("accestoken", null)

}
fun ComponentActivity.saverefreshToken(refreshtoken:String) {
    val editor = getSharedPreferences("Pr",
        ComponentActivity.MODE_PRIVATE
    ).edit() as SharedPreferences.Editor
    editor.putString("refreshtoken", refreshtoken!!)
    editor.commit()

}
fun ComponentActivity.loadRefreshToken():String? {
    val sharedPreferences = getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getString("refreshtoken", null)

}

fun ComponentActivity.saveChange(role:String) {
    val editor = getSharedPreferences("Pr",
        ComponentActivity.MODE_PRIVATE
    ).edit() as SharedPreferences.Editor
    editor.putString("usertype", role!!)
    editor.commit()

}

fun ComponentActivity.loadChange():String {
    val sharedPreferences = getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getString("usertype", null).toString()

}