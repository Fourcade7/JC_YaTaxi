package com.pr7.jc_yataxi.ui.driver_screens.home.driverbottomscreens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import com.pr7.jc_yataxi.R
import com.pr7.jc_yataxi.ui.data.network.models.userinfo.response.UserInfoChangeRCD
import com.pr7.jc_yataxi.ui.data.pref.DataStoreManager
import com.pr7.jc_yataxi.ui.screens.home.HomeViewModel
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.discoverScreen
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.orderScreen
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.profileScreen
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.regionsListScreen
import com.pr7.jc_yataxi.ui.screens.home.bottomscreens.seeatChooseScreen
import com.pr7.jc_yataxi.ui.screens.home.ui.theme.BottomColors

sealed class DriverBottomScreens constructor(
    val route: String,
    val title: String,
    val icon: Int
) {
    object DriverOrder : DriverBottomScreens(
        route = "driverorder_screen",
        title = "DriverOrder",
        icon = R.drawable.discover
    )

    object DriverDirection : DriverBottomScreens(
        route = "driverdirection_screen",
        title = "MyDirection",
        icon = R.drawable.order
    )

    object DriverProfile : DriverBottomScreens(
        route = "driverprofile_screen",
        title = "Profile",
        icon = R.drawable.usercirle
    )
    object DriverSeatChoose : DriverBottomScreens(
        route = "seat_screen",
        title = "SearChoose",
        icon = R.drawable.usercirle
    )

    object DriverRegions : DriverBottomScreens(
        route = "driverregions_screen",
        title = "DriverRegions",
        icon = R.drawable.usercirle
    )

}



@Composable
fun RowScope.addItem(
    screens:DriverBottomScreens,
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
fun DriverBottomBar(navHostController: NavHostController) {

    val screens = listOf(
        DriverBottomScreens.DriverOrder,
        DriverBottomScreens.DriverDirection,
        DriverBottomScreens.DriverProfile,

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


@ExperimentalMaterial3Api
@Composable
fun driverbottomNavGraphSetup(
    navHostController: NavHostController,
    dataStoreManager: DataStoreManager


) {


    NavHost(navController = navHostController, startDestination = DriverBottomScreens.DriverOrder.route){
        composable(route = DriverBottomScreens.DriverOrder.route){ driverOrderScreen()}
        composable(route = DriverBottomScreens.DriverDirection.route){ driverdirections() }
        composable(route = DriverBottomScreens.DriverProfile.route){ driverprofileScreen(dataStoreManager) }

    }
}
