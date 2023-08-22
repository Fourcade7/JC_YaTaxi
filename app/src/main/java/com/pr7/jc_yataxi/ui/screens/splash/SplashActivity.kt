package com.pr7.jc_yataxi.ui.screens.splash

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pr7.jc_yataxi.ui.data.pref.DataStoreManager
import com.pr7.jc_yataxi.ui.data.pref.loadOnboard
import com.pr7.jc_yataxi.ui.screens.change.ChangeActivity
import com.pr7.jc_yataxi.ui.screens.onboard.OnboardingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


lateinit var dataStoreManager: DataStoreManager

class MainActivity : ComponentActivity() {

    var savedtext = false

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        savedtext=loadOnboard()
        lifecycleScope.launch {
        if (savedtext) {
            delay(3000)
            startActivity(Intent(this@MainActivity, ChangeActivity::class.java))
        } else {
            delay(3000)
            startActivity(Intent(this@MainActivity, OnboardingActivity::class.java))
        }
    }

        setContent {
            statusbarcolorchange(window = window)
            splashScreen()
        }
    }





}


@Composable
fun statusbarcolorchange(window: Window) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }
}


