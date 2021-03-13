package com.example.androiddevchallenge

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : BottomNavigationScreens("home", R.string.home, Icons.Filled.Home)
    object Favourites : BottomNavigationScreens("favourites", R.string.favourites, Icons.Filled.FavoriteBorder)
    object Profile : BottomNavigationScreens("profile", R.string.profile, Icons.Filled.AccountCircle)
    object Cart : BottomNavigationScreens("cart", R.string.cart, Icons.Filled.ShoppingCart)
}

@Composable
fun MainPage(navController: NavHostController){
    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Favourites,
        BottomNavigationScreens.Profile,
        BottomNavigationScreens.Cart
    )
    val mainNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            SpookyAppBottomNavigation(mainNavController, bottomNavigationItems)
        },
    ) {
        MainScreenNavigationConfigurations(mainNavController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
        composable(BottomNavigationScreens.Home.route) {
            Home()
        }
        composable(BottomNavigationScreens.Favourites.route) {
            EmptyView()
        }
        composable(BottomNavigationScreens.Profile.route) {
            EmptyView()
        }
        composable(BottomNavigationScreens.Cart.route) {
            EmptyView()
        }
    }
}

@Composable
private fun EmptyView(){

}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}

@Composable
private fun SpookyAppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(
                    imageVector = screen.icon,
                    contentDescription = stringResource(id = screen.resourceId),
                    tint = MaterialTheme.colors.onPrimary
                ) },
                modifier = Modifier.background(MaterialTheme.colors.primary),
                label = { Text(stringResource(id = screen.resourceId),color = MaterialTheme.colors.onPrimary) },
                selected = currentRoute == screen.route,
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}