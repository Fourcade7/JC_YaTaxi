package com.pr7.jc_yataxi.ui.screens.change

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.screens.change.ui.theme.JC_YaTaxiTheme
import com.pr7.jc_yataxi.ui.theme.BorderBarColor
import com.pr7.jc_yataxi.ui.theme.CardbackgroundLanguage

class ChangeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            statusbarcolorchange(window = window)
            changeScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun changeScreen() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.frame),
            contentDescription = "frame",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Card(
            modifier = Modifier
                .padding(16.dp)
                .clickable {  },
            colors = CardDefaults.cardColors(CardbackgroundLanguage),
            shape = RoundedCornerShape(25.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.globe),
                    contentDescription = "globe",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "En",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.mont_semibold))
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrowdown),
                    contentDescription = "globe",
                    modifier = Modifier.size(25.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(32.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Who you are ?",
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.mont_bold))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable { },
                border = BorderStroke(width = 1.dp, color = BorderBarColor),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.passangervector),
                        contentDescription = "passenger",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Fit,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "I`m a Client",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.mont_semibold))
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.round_keyboard_arrow_right_24),
                        contentDescription = "arrow"
                    )

                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable { },
                border = BorderStroke(width = 1.dp, color = BorderBarColor),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.drivervector),
                        contentDescription = "driver",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Fit,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "I`m a Driver",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.mont_semibold))
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.round_keyboard_arrow_right_24),
                        contentDescription = "arrow"
                    )

                }
            }

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