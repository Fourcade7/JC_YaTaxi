@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.pr7.jc_yataxi.ui.screens.home.bottomscreens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jc_yataxi.R


@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun seeatChooseScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Card(
                modifier = Modifier.size(38.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {

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

                text = "Register",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(55.dp))
        Image(
            painter = painterResource(id = R.drawable.carseat),
            contentDescription = "ko`k moshin",
            modifier = Modifier.weight(2f).align(alignment = Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.3f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.seatblue),
                contentDescription = "ko`k moshin",
                modifier = Modifier
                    .width(60.dp)
                    .height(100.dp)
                    .align(alignment = Alignment.End)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.seatempty),
                    contentDescription = "ko`k moshin",
                    modifier = Modifier
                        .width(60.dp)
                        .height(100.dp).align(Alignment.CenterStart)

                )
                Image(
                    painter = painterResource(id = R.drawable.seatempty),
                    contentDescription = "ko`k moshin",
                    modifier = Modifier
                        .width(60.dp)
                        .height(100.dp).align(alignment = Alignment.Center)

                )
                Image(
                    painter = painterResource(id = R.drawable.seathidden),
                    contentDescription = "ko`k moshin",
                    modifier = Modifier
                        .width(60.dp)
                        .height(100.dp).align(alignment = Alignment.CenterEnd)

                )
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

    }

}