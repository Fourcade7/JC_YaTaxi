package com.pr7.jc_yataxi.ui.screens.home.bottomscreens

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.directions.DirectionsR
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.CardBackgroundTransparent
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.LayoutbackgroundColors
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage

///@Preview(showSystemUi = true, showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun orderScreen(homeViewModel: HomeViewModel) {
    val alltaxidriverslivedata: State<ArrayList<DirectionsR>?> = homeViewModel.mlivedataAllDrivers.observeAsState(null)
    val completeddrivers: State<Boolean?> = homeViewModel.completeddrivers.observeAsState()
    val succesdrivers: State<Boolean?> = homeViewModel.succesdrivers.observeAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(LayoutbackgroundColors)) {
        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Card(
                modifier = Modifier.size(38.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                   // navHostController.navigate(Screens.Discover.route)
                }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrowleft),
                        contentDescription = "logo2",
                        modifier = Modifier
                            .size(13.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(15.dp))
            Text(

                text = "Drivers",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                modifier = Modifier.align(Alignment.Center)
            )
        }


        Spacer(modifier = Modifier.height(15.dp))
        if (succesdrivers.value!!){
            Log.d("PR77777", "orderScreen: ${succesdrivers.value!!}")
            if (alltaxidriverslivedata.value!!.size >0){
                Log.d("PR77777", "orderScreen kak: ${alltaxidriverslivedata.value!!.size}")
                LazyColumn(){
                    itemsIndexed(alltaxidriverslivedata.value!!){index: Int, item: DirectionsR ->
                        lazyitemtaxis(directionsR = item)
                    }
                }
            }else{
                Log.d("PR77777", "orderScreen sizee: ${alltaxidriverslivedata.value!!.size}")

                Text(

                    text = "Currently, there is no taxi on this route",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.mont_semibold)),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }



        if (completeddrivers.value==false){
            Box(
                modifier=Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Loader()
            }
        }


    }



}


@Composable
fun Loader() {
    Column {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.data))
        val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(250.dp),
        )
    }

}


//@ExperimentalMaterial3Api
//@Preview(showSystemUi = true, showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun lazyitemtaxis(directionsR: DirectionsR) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(LayoutbackgroundColors)) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = CardDefaults.cardColors(Color.White)
        ){
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.driverrealimage),
                        contentDescription ="driver",
                        modifier = Modifier.size(60.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier.align(CenterVertically)) {
                        Text(
                            text = directionsR.driver.full_name,
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 23.sp,
                                fontFamily = FontFamily(Font(R.font.mont_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF17334C),

                            ),
                            maxLines = 1

                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = directionsR.car.name,
                            style = TextStyle(
                                fontSize = 13.sp,
                                lineHeight = 23.sp,
                                fontFamily = FontFamily(Font(R.font.mont_light)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF17334C),
                            )
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Card(

                        colors = CardDefaults.cardColors(CardBackgroundTransparent),
                        shape = RoundedCornerShape(19.dp),
                        onClick = {

                        }
                    ) {
                        Row(
                            modifier=Modifier.padding(start = 9.dp, end = 9.dp, top = 5.dp, bottom = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Image(
                                imageVector = Icons.Default.Star,
                                contentDescription = "edit",
                                modifier = Modifier.size(25.dp)
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "4.7",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.mont_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                )
                            )

                        }
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "Departure: ${directionsR.start_date}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.mont_light)),
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                        textAlign = TextAlign.Center,

                    ),

                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Passangers:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.mont_light)),
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Car number: ${directionsR.car_number}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.mont_light)),
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(54.dp)
                        .clickable {

                        },
                    shape = RoundedCornerShape(10.dp),
                    color = ButtonbackgroundLanguage
                ) {
                    Column(verticalArrangement = Arrangement.Center) {

                        Text(
                            text = "Request a quote",
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