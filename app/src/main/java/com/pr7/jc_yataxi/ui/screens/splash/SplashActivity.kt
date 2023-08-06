package com.pr7.jc_yataxi.ui.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pr7.jc_yataxi.ui.screens.change.ChangeActivity
import com.pr7.jc_yataxi.ui.screens.onboard.OnboardingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            statusbarcolorchange(window = window)

            splashScreen()
            lifecycleScope.launch {
                delay(3000)
                startActivity(Intent(this@MainActivity,OnboardingActivity::class.java))
                finish()
            }

        }
    }


}


@Composable
fun statusbarcolorchange(window:Window) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }
}

