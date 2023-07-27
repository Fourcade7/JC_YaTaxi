@file:OptIn(ExperimentalFoundationApi::class)

package com.pr7.jc_yataxi.ui.screens.onboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.screens.change.statusbarcolorchange
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage
import kotlinx.coroutines.launch

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            statusbarcolorchange(window = window)
            onBoardMain()
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun onBoardMain() {
    val pagerState = rememberPagerState { 3 }
    val scope = rememberCoroutineScope()

    Column() {
        Column(modifier = Modifier.weight(2f),
        verticalArrangement = Arrangement.Bottom) {
            onBoardingScreen(pagerState = pagerState)
        }
        Column(modifier = Modifier.weight(1f).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(
                    id = when(pagerState.currentPage){
                        0->{R.drawable.dot1}
                        1->{R.drawable.dot2}
                        2->{R.drawable.dot3}
                        else->{R.drawable.dot1}
                    }
                ),
                contentDescription = "dot",
                modifier = Modifier.size(70.dp).align(alignment = CenterHorizontally)
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(54.dp)
                .clickable {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                },
            shape = RoundedCornerShape(15.dp),
            color = ButtonbackgroundLanguage
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Next",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.mont_semibold)),
                    fontSize = 17.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(15.dp))

    }

}

