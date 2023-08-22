package com.pr7.jc_yataxi.ui.screens.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.pr7.jc_yataxi.ui.data.network.models.login.request.LoginCD
import com.pr7.jc_yataxi.ui.data.network.models.login.response.LoginRCD
import com.pr7.jc_yataxi.ui.data.network.models.register.request.RegisterCD
import com.pr7.jc_yataxi.ui.data.network.models.register.response.RegisterRCD
import com.pr7.jc_yataxi.ui.screens.login.ui.theme.JC_YaTaxiTheme
import com.pr7.jc_yataxi.ui.screens.otp.OTPVerificationActivity
import com.pr7.jc_yataxi.ui.screens.register.RegisterActivity
import com.pr7.jc_yataxi.ui.screens.register.RegisterViewModel
import com.pr7.jc_yataxi.ui.screens.register.ui.theme.FocusedBorderColor
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage

class LoginActivity : ComponentActivity() {

    val loginViewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                loginScreen(loginViewModel = loginViewModel)
            loginViewModel.mlivedataLoginRCD.observe(this@LoginActivity){
                Log.d("PR77777", "onCreate LOGIN Activity: ${it.otp}")
                Log.d("PR77777", "onCreate LOGIN Activity: ${it.message}")
                Log.d("PR77777", "onCreate LOGIN Activity: ${it.statuscode}")
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginScreen(loginViewModel: LoginViewModel) {
    val context= LocalContext.current
    val completed: State<Boolean> = loginViewModel.completed.observeAsState(true)
    val loginresponse: State<LoginRCD?> = loginViewModel.mlivedataLoginRCD.observeAsState()
    var succes: State<Boolean?> = loginViewModel.succes.observeAsState(null)

    var name by remember {
        mutableStateOf("")
    }
    if (succes.value==true) {
        val intent = Intent(context, OTPVerificationActivity::class.java)
        intent.apply {
            putExtra("otpcode","${loginresponse.value?.otp}")
            putExtra("phonenumber","$name")
        }
        ///loginViewModel.succes.postValue(false)
        context.startActivity(intent)

    }
    if (succes.value==false){
        val intent = Intent(context, RegisterActivity::class.java)
        context.startActivity(intent)
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        Spacer(modifier = Modifier.height(35.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "logo2",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(

                text ="YaTaxi",
                textAlign = TextAlign.Start,
                fontSize = 26.sp,
                fontFamily = FontFamily(Font(R.font.mont_bold))
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text ="Welcome Login",
            textAlign = TextAlign.Start,
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.mont_bold))
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text ="Enter your phone number",
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.mont_light))
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                if (it.length < 10) {
                    name = it
                }
            },
            label = {
                Text(text = "Phone")
            },
            placeholder = {
                Text(text = "+998")
            },
            maxLines = 1,
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Call, contentDescription = "")
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = if (name.length<9)  Color.Red  else FocusedBorderColor, focusedLabelColor =if (name.length<9)  Color.Red  else FocusedBorderColor)
        )

        Spacer(modifier = Modifier.height(15.dp))
        if (!completed.value){
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                strokeWidth =10.dp
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(54.dp)
                .clickable {
                    loginViewModel.loginrCD(LoginCD(phone = name))
                },
            shape = RoundedCornerShape(15.dp),
            color = ButtonbackgroundLanguage,
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Continue",
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
