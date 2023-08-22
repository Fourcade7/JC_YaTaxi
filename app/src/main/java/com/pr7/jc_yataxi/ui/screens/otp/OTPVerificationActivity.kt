package com.pr7.jc_yataxi.ui.screens.otp

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.lifecycleScope
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.verify_otp.request.OtpCD
import com.pr7.jc_yataxi.ui.data.pref.saveToken
import com.pr7.jc_yataxi.ui.data.pref.saverefreshToken
import com.pr7.jc_yataxi.ui.screens.home.HomeActivity
import com.pr7.jc_yataxi.ui.screens.register.RegisterActivity
import com.pr7.jc_yataxi.ui.screens.register.ui.theme.FocusedBorderColor
import com.pr7.jc_yataxi.ui.theme.ButtonbackgroundLanguage
import com.pr7.jc_yataxi.ui.utils.showlogd
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OTPVerificationActivity : ComponentActivity() {
    val otpViewModel: OtpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkpermissioins()
        val otpcode = intent.getStringExtra("otpcode")
        val phone = intent.getStringExtra("phonenumber")
        otpViewModel.verifyotp(otpCD = OtpCD(otpcode!!))
        otpViewModel.succes.observe(this@OTPVerificationActivity){
            receivemsg()
            if (it){
                otpViewModel.mlivedataOtpRCD.observe(this@OTPVerificationActivity){
                    Log.d("PR77777", "OTP Activity acces token: ${it.access}")
                    Log.d("PR77777", "OTP Activity refresh: ${it.refresh}")
                    saveToken(it.access)
                    saverefreshToken(it.refresh)
                    val intent = Intent(this@OTPVerificationActivity, HomeActivity::class.java)
                    lifecycleScope.launch {
                       delay(6000)
                       //startActivity(intent)
                   }
                }
            }

        }

        setContent {
            otpverifyScreen(otpViewModel = otpViewModel, otpcode = otpcode!!, phone = phone!!)
        }
    }

    fun checkpermissioins(){
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_MMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS),101)
        } else {

        }
    }


    private fun receivemsg() {
        var br  = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    for (sms: SmsMessage in Telephony.Sms.Intents.getMessagesFromIntent(p1)){
                        showlogd(sms.displayMessageBody.toString().isDigitsOnly().toString())
                        Toast.makeText(applicationContext,sms.displayMessageBody,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        registerReceiver(br, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun otpverifyScreen(otpViewModel: OtpViewModel, otpcode: String, phone: String) {
    val context = LocalContext.current
    val focusRequester = FocusRequester()
    val scope = rememberCoroutineScope()
    var reqfocus by remember {
        mutableStateOf(focusRequester)
    }

    var otp1 by remember {
        mutableStateOf("")
    }
    var otp2 by remember {
        mutableStateOf("")
    }
    var otp3 by remember {
        mutableStateOf("")
    }
    var otp4 by remember {
        mutableStateOf("")
    }
    var otp5 by remember {
        mutableStateOf("")
    }
    var otp6 by remember {
        mutableStateOf("")
    }


    scope.launch {

        delay(1000)
        otp1 = otpcode.get(0).toString()
        delay(1000)
        otp2 = otpcode.get(1).toString()
        delay(1000)
        otp3 = otpcode.get(2).toString()
        delay(1000)
        otp4 = otpcode.get(3).toString()
        delay(1000)
        otp5 = otpcode.get(4).toString()
        delay(1000)
        otp6 = otpcode.get(5).toString()


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

                text = "OTP Verification",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Verify your number",
            textAlign = TextAlign.Start,
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.mont_bold))
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "The verification code has been sent to +99850 074 ** **. Please enter the code.",
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.mont_light))
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = otp1,
                onValueChange = {
                    if (it.length < 2) {
                        otp1 = it
                    }
                },
                placeholder = {
                    Text(text = "")
                },
                maxLines = 1,

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = FocusedBorderColor,
                    focusedLabelColor = FocusedBorderColor,
                    unfocusedBorderColor = if (otp1.length==1) FocusedBorderColor else Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 15.sp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = otp2,
                onValueChange = {
                    if (it.length < 2) {
                        otp2 = it
                    }
                },
                maxLines = 1,

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = FocusedBorderColor,
                    focusedLabelColor = FocusedBorderColor,
                    unfocusedBorderColor = if (otp2.length==1) FocusedBorderColor else Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 15.sp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = otp3,
                onValueChange = {
                    if (it.length< 2) {
                        otp3 = it
                    }
                },
                placeholder = {
                    Text(text = "")
                },
                maxLines = 1,

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = FocusedBorderColor,
                    focusedLabelColor = FocusedBorderColor,
                    unfocusedBorderColor = if (otp3.length==1) FocusedBorderColor else Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 15.sp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = otp4,
                onValueChange = {
                    if (it.length < 2) {
                        otp4 = it
                    }
                },
                maxLines = 1,

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = FocusedBorderColor,
                    focusedLabelColor = FocusedBorderColor,
                    unfocusedBorderColor = if (otp4.length==1) FocusedBorderColor else Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 15.sp)

            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = otp5,
                onValueChange = {
                    if (it.length < 2) {
                        otp5 = it
                    }
                },
                maxLines = 1,

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = FocusedBorderColor,
                    focusedLabelColor = FocusedBorderColor,
                    unfocusedBorderColor = if (otp5.length==1) FocusedBorderColor else Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 15.sp)

            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = otp6,
                onValueChange = {
                    if (it.length < 2) {
                        otp6 = it
                    }
                },
                maxLines = 1,

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = FocusedBorderColor,
                    focusedLabelColor = FocusedBorderColor,
                    unfocusedBorderColor = if (otp6.length==1) FocusedBorderColor else Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 15.sp)

            )
        }


        Spacer(modifier = Modifier.weight(1f))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(54.dp)
                .clickable {
                    context.startActivity(Intent(context, HomeActivity::class.java))
                },
            shape = RoundedCornerShape(15.dp),
            color = ButtonbackgroundLanguage
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Continue",
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


