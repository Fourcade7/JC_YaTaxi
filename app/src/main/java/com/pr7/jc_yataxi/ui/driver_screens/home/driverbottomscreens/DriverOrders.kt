@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.pr7.jc_yataxi.ui.driver_screens.home.driverbottomscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.Screens
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.CardStrokeColors
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.LayoutbackgroundColors
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage


@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun driverOrderScreen() {

    Column(
        modifier = Modifier.background(LayoutbackgroundColors)
    ) {

        Column( modifier = Modifier
            .padding(15.dp)) {
            Text(

                text = "new Direction",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                //modifier = Modifier.align(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(

                text = "From",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                //modifier = Modifier.align(Alignment.Center)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(width = 1.dp,color = CardStrokeColors),

            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "Select Region",
                        modifier = Modifier.align(Alignment.CenterStart)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.arrowdown),
                        contentDescription = "Done",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .width(27.dp)
                            .height(45.dp)
                    )






                }
            }
            Spacer(modifier = Modifier.height(12.dp))


            Text(

                text = "To",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                //modifier = Modifier.align(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Card(
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(width = 1.dp,color = CardStrokeColors),

                ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "Select Region",
                        modifier = Modifier.align(Alignment.CenterStart)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.arrowdown),
                        contentDescription = "Done",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .width(27.dp)
                            .height(45.dp)
                    )






                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(

                text = "Select Time",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                //modifier = Modifier.align(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.weight(1f),
                    border = BorderStroke(width = 1.dp,color = CardStrokeColors),
                    onClick = {
                       // timePicker.show()
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
                            modifier = Modifier.align(Alignment.CenterVertically),
                            colors = CardDefaults.cardColors(LayoutbackgroundColors),

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
                                text = "08:00",
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
                           // navController.navigate(route = Screens.SeatChoose.route)
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
                            modifier = Modifier.align(Alignment.CenterVertically),
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
                                text = "12:00",
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

            Spacer(modifier = Modifier.height(12.dp))







            Text(

                text = "Passengers count",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                //modifier = Modifier.align(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(12.dp))
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
                        modifier = Modifier.align(Alignment.CenterVertically),
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
                            text = "+",
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
                            modifier = Modifier.align(Alignment.CenterVertically),
                            colors = CardDefaults.cardColors(LayoutbackgroundColors),
                            onClick = {
//                                if (passangercount>1){
//                                    passangercount--
//                                }

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
                            modifier = Modifier.align(Alignment.CenterVertically),
                            colors = CardDefaults.cardColors(ButtonbackgroundLanguage),
                            onClick = {
                                //passangercount++

                            }
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
            Spacer(modifier = Modifier.height(12.dp))

            Text(

                text = "Seat Choose",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                //modifier = Modifier.align(Alignment.Center)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier

                    .clickable {
                       // navController.navigate(route = Screens.SeatChoose.route)
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
                        modifier = Modifier.align(Alignment.CenterVertically),
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

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(54.dp)
                    .clickable {
                        //navController.navigate(Screens.Orders.route)
                    },
                shape = RoundedCornerShape(15.dp),
                color = ButtonbackgroundLanguage
            ) {
                Column(verticalArrangement = Arrangement.Center) {

                    Text(
                        text = "new Direction",
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