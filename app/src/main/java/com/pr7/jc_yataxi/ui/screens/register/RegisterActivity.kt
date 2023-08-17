@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.pr7.jc_yataxi.ui.screens.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.screens.login.ui.theme.FocusedBorderColor
import com.pr7.jc_yataxi.ui.screens.register.ui.theme.JC_YaTaxiTheme
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage

@OptIn(ExperimentalMaterial3Api::class)
class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            registerScreen()
        }
    }
}


@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun registerScreen() {
    var checked by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current
    var name by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
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
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            text ="First name",
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.mont_semibold))
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                if (it.length < 15) {
                    name = it
                }
            },
            placeholder = {
                Text(text = "Enter first name")
            },
            maxLines = 1,
            singleLine = true,

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = FocusedBorderColor, focusedLabelColor = FocusedBorderColor)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            text ="Last name",
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.mont_semibold))
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                if (it.length < 15) {
                    name = it
                }
            },
            placeholder = {
                Text(text = "Enter last name")
            },
            maxLines = 1,
            singleLine = true,

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = FocusedBorderColor, focusedLabelColor = FocusedBorderColor)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked_ ->
                    checked = checked_
                }
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                text ="By registering, you agree to our terms of use.",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.mont_light))
            )
        }



        Spacer(modifier = Modifier.weight(1f))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(54.dp)
                .clickable {},
            shape = RoundedCornerShape(15.dp),
            color = ButtonbackgroundLanguage
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Register",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.mont_semibold)),
                    fontSize = 17.sp,

                    )
            }

        }
        Spacer(modifier = Modifier.height(15.dp))



    }
}