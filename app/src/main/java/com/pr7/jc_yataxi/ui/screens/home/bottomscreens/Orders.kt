package com.pr7.jc_yataxi.ui.screens.home.bottomscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pr7.jc_yataxi.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun orderScreen() {
    Box(
        modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Loader()
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