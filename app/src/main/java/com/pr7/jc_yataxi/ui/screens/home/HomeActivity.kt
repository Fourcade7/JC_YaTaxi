package com.pr7.jc_yataxi.ui.screens.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pr7.jc_yataxi.ui.screens.change.statusbarcolorchange
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.BottomBar
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.Screens
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.bottomNavGraphSetup
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.JC_YaTaxiTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            statusbarcolorchange(window = window)
            bottombarScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun bottombarScreen() {


    val navController = rememberNavController()
    Scaffold(
        bottomBar ={ BottomBar(navHostController = navController) }
    ) {
        bottomNavGraphSetup(navHostController = navController)
        //navController.navigate(route = Screens.SeatChoose.route)
    }
}
