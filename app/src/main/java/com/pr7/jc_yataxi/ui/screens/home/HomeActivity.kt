package com.pr7.jc_yataxi.ui.screens.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.pref.DataStoreManager
import com.pr7.jc_yataxi.ui.data.pref.loadRefreshToken
import com.pr7.jc_yataxi.ui.data.pref.loadToken
import com.pr7.jc_yataxi.ui.data.pref.saveToken
import com.pr7.jc_yataxi.ui.data.pref.saverefreshToken
import com.pr7.jc_yataxi.ui.screens.change.dataStoreManager
import com.pr7.jc_yataxi.ui.screens.change.statusbarcolorchange
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.BottomBar
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.Screens
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.bottomNavGraphSetup
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.JC_YaTaxiTheme
import com.pr7.jc_yataxi.ui.screens.otp.OTPVerificationActivity
import com.pr7.jc_yataxi.ui.screens.registername.RegisterNameActivity
import com.pr7.jc_yataxi.ui.utils.showlogd

class HomeActivity : ComponentActivity() {
    val homeViewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showlogd(loadToken().toString())
        showlogd(loadRefreshToken().toString())
        if (loadRefreshToken()!=null && loadToken()!=null){
            homeViewModel.getnewFerfesh(loadRefreshToken().toString())
            homeViewModel.succesref.observe(this@HomeActivity){
                if (it){
                    homeViewModel.mlivedataFerFeshToken.observe(this@HomeActivity){ferfesh->
                        if (ferfesh!=null){
                            saveToken(ferfesh.acces.toString())
                            saverefreshToken(ferfesh.refresh.toString())
                        }
                    }
                }
            }
        }
        if (loadToken()!=null){
            homeViewModel.getUserIinfoCD(loadToken().toString())
            //request here for regions
        }else{
            showlogd("token null")
        }
        setContent {
            var userinfoChangeState by remember {
                mutableStateOf(UserInfoChangeRCD())
            }
            homeViewModel.succes.observe(this@HomeActivity){
                showlogd("succes $it")
                if (it){
                    homeViewModel.mlivedatagetUserInfoRCD.observe(this@HomeActivity){
                        showlogd(it.id.toString())
                        showlogd(it.first_name.toString())
                        showlogd(it.last_name.toString())
                        showlogd(it.phone.toString())
                        showlogd(it.user_type.toString())

                        if (it.first_name==null){
                            val intent = Intent(this@HomeActivity, RegisterNameActivity::class.java)
                            intent.apply {
                                putExtra("fname","${it.first_name}")
                                putExtra("lname","${it.last_name}")
                                putExtra("utype","${it.user_type}")
                            }
                            startActivity(intent)
                            finish()
                        }else{
                            userinfoChangeState=it
                        }
                    }
                }
            }


            statusbarcolorchange(window = window)
            bottombarScreen(userinfoChangeState, homeViewModel = homeViewModel,loadToken().toString(),dataStoreManager)
        }

        homeViewModel.regfromid.observe(this@HomeActivity){
            showlogd("regions from id=$it")
        }
        homeViewModel.regtoid.observe(this@HomeActivity){
            showlogd("regions to id=$it")
        }

        homeViewModel.disfromid.observe(this@HomeActivity){
            showlogd("district from id=$it")
        }

        homeViewModel.distoid.observe(this@HomeActivity){
            showlogd("district to id=$it")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun bottombarScreen(userInfoChangeRCD: UserInfoChangeRCD,homeViewModel: HomeViewModel,token:String,dataStoreManager: DataStoreManager) {

    val navController = rememberNavController()
    Scaffold(
        bottomBar ={ BottomBar(navHostController = navController) }
    ) {
        bottomNavGraphSetup(navHostController = navController, userInfoChangeRCD = userInfoChangeRCD, homeViewModel = homeViewModel,token,dataStoreManager)
        //navController.navigate(route = Screens.SeatChoose.route)
    }
}
