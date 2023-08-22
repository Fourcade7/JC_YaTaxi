@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.pr7.jc_yataxi.ui.screens.home.bottomscreens

import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calendar
import androidx.compose.ui.layout.ContentScale
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.login.response.LoginRCD
import com.pr7.jc_yataxi.ui.data.network.models.regions.response.RegionsR
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.screens.home.HomeActivity
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.CardStrokeColors
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.LayoutbackgroundColors
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage


//@Preview(showSystemUi = true, showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun discoverScreen(navController: NavController,userInfoChangeRCD: UserInfoChangeRCD,homeViewModel: HomeViewModel) {


    val context = LocalContext.current
    val calendar = java.util.Calendar.getInstance()

    var selectedTimeText by remember {
        mutableStateOf("00:00")
    }

    // Fetching current hour, and minute
    var hour = calendar[java.util.Calendar.HOUR_OF_DAY]
    var minute = calendar[java.util.Calendar.MINUTE]

    val timePicker = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            selectedTimeText = "$selectedHour:$selectedMinute"
        }, hour, minute, false
    )




    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .weight(1.7f)
                .fillMaxSize()

        ) {
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxSize()
                    .background(color = Color(0xFF17334C))
                    .padding(bottom = 35.dp)
            ) {
                Column(Modifier.padding(start = 16.dp, end = 16.dp, top = 55.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Assalomu aleykum",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.mont_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.sayhello),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(25.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "${userInfoChangeRCD.first_name} ${userInfoChangeRCD.last_name}",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.mont_bold)),
                            fontWeight = FontWeight(800),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

            }
            Spacer(
                modifier = Modifier
                    .height(65.dp)
                    .background(color = LayoutbackgroundColors)
                    .fillMaxWidth()
                    .align(
                        Alignment.BottomCenter
                    )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(horizontal = 16.dp)
                    .align(alignment = Alignment.BottomCenter),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(width = 1.dp,color = CardStrokeColors),
                onClick = {}
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.directionimage),
                        contentDescription = "",
                        modifier = Modifier.fillMaxHeight()
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Column(Modifier.clickable {
                            navController.navigate(Screens.Regions.route)
                        }) {
                            Text(
                                text = "From",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 23.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF17334C),
                                )
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Select location",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 23.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF17334C),
                                )
                            )
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                        )

                        Column(modifier = Modifier
                            .align(Alignment.BottomStart)
                            .clickable { }) {
                            Text(
                                text = "To",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 23.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF17334C),
                                )
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Select location",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 23.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF17334C),
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))
                    Card(
                        elevation = CardDefaults.cardElevation(1.dp),
                        shape = CircleShape,
                        modifier = Modifier.align(CenterVertically),
                        colors = CardDefaults.cardColors(LayoutbackgroundColors)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrowsort),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp)

                                .background(LayoutbackgroundColors)
                                .clip(RoundedCornerShape(100))
                                .padding(6.dp)
                        )
                    }


                }

            }

        }
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxSize()
                .background(color = LayoutbackgroundColors)

        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Text(
                    text = "Additional filters",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.mont_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF17334C),
                    ),
                    modifier = Modifier.padding(top = 10.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        colors = CardDefaults.cardColors(Color.White),
                        modifier = Modifier.weight(1f),
                        border = BorderStroke(width = 1.dp,color = CardStrokeColors),
                        onClick = {
                            timePicker.show()
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                elevation = CardDefaults.cardElevation(1.dp),
                                shape = CircleShape,
                                modifier = Modifier.align(CenterVertically),
                                colors = CardDefaults.cardColors(LayoutbackgroundColors)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.clockcircle),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(5.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))


                            Column {
                                Text(
                                    text = "Time",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 23.sp,
                                        fontFamily = FontFamily(Font(R.font.mont_light)),
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF17334C),
                                    )
                                )
                                Spacer(modifier = Modifier.height(7.dp))

                                Text(
                                    text = "$selectedTimeText",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 23.sp,
                                        fontFamily = FontFamily(Font(R.font.mont_bold)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF17334C),
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Card(
                        colors = CardDefaults.cardColors(Color.White),
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                navController.navigate(route = Screens.SeatChoose.route)
                            },
                        border = BorderStroke(width = 1.dp,color = CardStrokeColors),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                elevation = CardDefaults.cardElevation(1.dp),
                                shape = CircleShape,
                                modifier = Modifier.align(CenterVertically),
                                colors = CardDefaults.cardColors(LayoutbackgroundColors)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.seat),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(5.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))


                            Column {
                                Text(
                                    text = "Seat Position",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 23.sp,
                                        fontFamily = FontFamily(Font(R.font.mont_light)),
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF17334C),
                                    )
                                )
                                Spacer(modifier = Modifier.height(7.dp))

                                Text(
                                    text = "All",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 23.sp,
                                        fontFamily = FontFamily(Font(R.font.mont_bold)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF17334C),
                                    )
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp,color = CardStrokeColors),
                    onClick = {}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            elevation = CardDefaults.cardElevation(1.dp),
                            shape = CircleShape,
                            modifier = Modifier.align(CenterVertically),
                            colors = CardDefaults.cardColors(LayoutbackgroundColors)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.passangeway),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(5.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))


                        Column {
                            Text(
                                text = "Passengers",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 23.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF17334C),
                                )
                            )
                            Spacer(modifier = Modifier.height(7.dp))

                            Text(
                                text = "1",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 23.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_bold)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF17334C),
                                )
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row {
                            Card(
                                elevation = CardDefaults.cardElevation(1.dp),
                                shape = CircleShape,
                                modifier = Modifier.align(CenterVertically),
                                colors = CardDefaults.cardColors(LayoutbackgroundColors),
                                onClick = {

                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.minus),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(5.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Card(
                                elevation = CardDefaults.cardElevation(1.dp),
                                shape = CircleShape,
                                modifier = Modifier.align(CenterVertically),
                                colors = CardDefaults.cardColors(ButtonbackgroundLanguage),
                                onClick = {}
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.plus),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(5.dp)
                                )
                            }
                        }


                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(54.dp)
                        .clickable {
                            //context.startActivity(Intent(context, HomeActivity::class.java))
                        },
                    shape = RoundedCornerShape(15.dp),
                    color = ButtonbackgroundLanguage
                ) {
                    Column(verticalArrangement = Arrangement.Center) {

                        Text(
                            text = "Find Drivers",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.mont_semibold)),
                            fontSize = 17.sp,

                            )
                    }

                }
            }


        }
    }
}