package com.pr7.jc_yataxi.ui.driver_screens.home.driverbottomscreens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.pref.DataStoreManager
import com.pr7.jc_yataxi.ui.screens.home.HomeActivity
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.CardBackgroundTransparent
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.LayoutbackgroundColors
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun driverprofileScreen(dataStoreManager:DataStoreManager) {
    //val districtchoose: State<Userin> = homeViewModel.districtchoose.observeAsState()
    val scope= rememberCoroutineScope()
    val context= LocalContext.current

    Column(modifier = Modifier.background(LayoutbackgroundColors)) {

        Box(
            modifier = Modifier
                .weight(1.2f)
                .fillMaxWidth()
                .background(color = Color(0xFF17334C))
        ) {

            Box(
                Modifier
                    .padding(top = 50.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "version 1.0.0",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.mont_light)),
                        fontWeight = FontWeight(600),
                        color = Color(0x7CEBE4E4),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 15.dp)
                )
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    colors = CardDefaults.cardColors(CardBackgroundTransparent),
                    shape = RoundedCornerShape(19.dp),
                    onClick = {

                    }
                ) {
                    Row(
                        modifier= Modifier.padding(start = 9.dp, end = 9.dp, top = 5.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.editicon),
                            contentDescription = "edit",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            text = "Edit",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.mont_light)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFCD33),
                                textAlign = TextAlign.Center,
                            )
                        )

                    }
                }

            }


            Spacer(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(LayoutbackgroundColors)

            )
            Image(
                painter = painterResource(id = R.drawable.driverrealimage),
                contentDescription = "driver",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomCenter)
                    .border(width = 3.dp, color = Color.White, shape = CircleShape)
                    .clip(CircleShape),
            )

        }
        Column(modifier = Modifier.weight(3f)) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Aminov Fourcade 7",
                textAlign = TextAlign.Center,
                fontSize = 23.sp,
                fontFamily = FontFamily(Font(R.font.mont_bold))
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "+998918607335",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_light))
            )


            Card (modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), colors = CardDefaults.cardColors(Color.White)){
                Column(modifier = Modifier.padding(15.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.globesettings),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(

                            text = "Change Language",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.mont_semibold))
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.arrowrightregions),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.halfmoon),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(

                            text = "Dark Mode",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.mont_semibold))
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.arrowrightregions),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.supportsettings),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(

                            text = "Support",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.mont_semibold))
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.arrowrightregions),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.help),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(

                            text = "About App",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.mont_semibold))
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.arrowrightregions),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(

                            text = "Log Out",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.mont_semibold))
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.arrowrightregions),
                            contentDescription ="global",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Spacer(modifier = Modifier.height(15.dp))
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .height(54.dp)
                            .clickable {
                                scope.launch {
                                    dataStoreManager.saveString("usertype","client")
                                }
                                context.startActivity(Intent(context, HomeActivity::class.java))
                            },
                        shape = RoundedCornerShape(15.dp),
                        color = ButtonbackgroundLanguage
                    ) {
                        Column(verticalArrangement = Arrangement.Center) {

                            Text(
                                text = "Change to Client",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                                fontSize = 17.sp,)
                        }

                    }

                }
            }
        }
    }
}