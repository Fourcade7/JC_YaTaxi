@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.pr7.jc_yataxi.ui.screens.home.bottomscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.BottomColors

sealed class Screens constructor(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Discover : Screens(
        route = "discover_screen",
        title = "Discover",
        icon = R.drawable.discover
    )

    object Orders : Screens(
        route = "order_screen",
        title = "Order",
        icon = R.drawable.order
    )

    object Profile : Screens(
        route = "profile_screen",
        title = "Profile",
        icon = R.drawable.usercirle
    )
    object SeatChoose : Screens(
        route = "seat_screen",
        title = "SearChoose",
        icon = R.drawable.usercirle
    )

    object Regions : Screens(
        route = "regions_screen",
        title = "Regions",
        icon = R.drawable.usercirle
    )



}



@Composable
fun RowScope.addItem(
    screens: Screens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    NavigationBarItem(
        label = {
            Text(
                text = screens.title,
                fontFamily = FontFamily(Font(R.font.mont_bold))
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screens.icon),
                contentDescription = "",
                modifier = Modifier
                    .size(35.dp)
                    .padding(bottom = 5.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == screens.route } == true,
        onClick = {
            navHostController.navigate(screens.route)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = BottomColors,
            selectedTextColor = BottomColors,
            indicatorColor = Color.White,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        ),



        )
}



@Composable
fun BottomBar(navHostController: NavHostController) {

    val screens = listOf(
        Screens.Discover,
        Screens.Orders,
        Screens.Profile,

    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White
    ) {
        screens.forEach {
            addItem(
                screens = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }

}


@Composable
fun bottomNavGraphSetup(
    navHostController: NavHostController,
    userInfoChangeRCD: UserInfoChangeRCD,
    homeViewModel: HomeViewModel,
    token:String

) {


    NavHost(navController = navHostController, startDestination = Screens.Discover.route ){
        composable(route = Screens.Discover.route){ discoverScreen(navHostController,userInfoChangeRCD,homeViewModel) }
        composable(route = Screens.Orders.route){ orderScreen() }
        composable(route = Screens.Profile.route){ profileScreen() }
        composable(route = Screens.SeatChoose.route){ seeatChooseScreen() }
        composable(route = Screens.Regions.route){ regionsListScreen(navHostController = navHostController, homeViewModel = homeViewModel, token = token) }



    }
}



