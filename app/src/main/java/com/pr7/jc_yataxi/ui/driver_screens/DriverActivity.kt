package com.pr7.jc_yataxi.ui.driver_screens

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
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.pref.DataStoreManager
import com.pr7.jc_yataxi.ui.driver_screens.home.driverbottomscreens.DriverBottomBar
import com.pr7.jc_yataxi.ui.driver_screens.home.driverbottomscreens.driverbottomNavGraphSetup
import com.pr7.jc_yataxi.ui.driver_screens.ui.theme.JC_YaTaxiTheme
import com.pr7.jc_yataxi.ui.screens.change.statusbarcolorchange
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.BottomBar
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.bottomNavGraphSetup
lateinit var dataStoreManager: DataStoreManager

class DriverActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStoreManager =DataStoreManager(this@DriverActivity)

        setContent {
            statusbarcolorchange(window = window)

            driverbottombarScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun driverbottombarScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar ={ DriverBottomBar(navHostController = navController) }
    ) {
        driverbottomNavGraphSetup(navHostController = navController, dataStoreManager)
        //navController.navigate(route = Screens.SeatChoose.route)
    }
}