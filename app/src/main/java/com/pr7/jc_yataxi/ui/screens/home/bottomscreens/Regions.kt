@file:OptIn(ExperimentalMaterial3Api::class)

package com.pr7.jc_yataxi.ui.screens.home.bottomscreens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.regions.response.RegionsR
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch


//@Preview(showBackground = true, showSystemUi = true)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun regionsListScreen(navHostController: NavHostController,homeViewModel: HomeViewModel,token:String) {

    homeViewModel.getAllRegionsCD(token)


    val arrayRegions : State<ArrayList<RegionsR>?> = homeViewModel.mlivedataAllRegionsCD.observeAsState()
    val scope= rememberCoroutineScope()


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

                text = "Regions",
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.mont_semibold)),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(55.dp))
       scope.launch {
           homeViewModel.succesreg.mapLatest {
               Log.d("PR77777", "regionsListScreen: Succes State ${it} ")

           }
       }

        if (arrayRegions.value!=null){
            Log.d("PR77777", "regionsListScreen: livedata  ")

            LazyColumn(){
                itemsIndexed(arrayRegions.value!!){index: Int, item: RegionsR ->
                    lazyselectitem(item)
                }
            }
        }





    }
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun lazyselectitem(regionsR: RegionsR) {
    var selecteditem by remember {
        mutableStateOf("item.selected")
    }

    Column(modifier = Modifier.clickable {

    }) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()

        ) {
            Text(
                text = regionsR.name.toString(),
                modifier = Modifier.align(Alignment.CenterStart)
            )

            Icon(
                painter = painterResource(id = R.drawable.arrowrightregions),
                contentDescription = "Done",
                modifier = Modifier.align(Alignment.CenterEnd)
            )



        }
        Divider(modifier = Modifier.padding(horizontal = 16.dp))

    }



}