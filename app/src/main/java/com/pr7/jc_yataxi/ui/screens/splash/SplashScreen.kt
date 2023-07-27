package com.pr7.jc_yataxi.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.theme.StatusBarColor


@Composable
fun splashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StatusBarColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription ="logo" ,
            modifier = Modifier.size(width = 144.dp, height = 175.dp)
        )
    }
}