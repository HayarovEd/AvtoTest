package com.eedurda77.avtotest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eedurda77.avtotest.presentation.autoinfo.AutoInfoScreen
import com.eedurda77.avtotest.presentation.autolist.AutoListScreen

@Composable
fun NavController(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController, startDestination = startDestination) {
        composable(NavigationDestination.AutosListScreen.destination) {
            AutoListScreen(
                navController = navController
            )
        }
        composable(NavigationDestination.AutoInfoScreen.destination) {
            //val id = it.arguments?.getString(SEC_ID) ?: ""
            AutoInfoScreen(
                navController = navController
            )
        }
    }
}