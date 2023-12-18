package com.example.s_app9.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.s_app9.Screans.home.homes.HomeScrean
import com.example.s_app9.Screans.home.details.DetailsScreans

@Composable
fun MovieNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreans.HomeScrean.name){
        composable(MovieScreans.HomeScrean.name){
            HomeScrean(navController = navController)
        }
        composable(MovieScreans.DetailsScrean.name+"/{Movie}",
            arguments = listOf(navArgument(name = "Movie"){type= NavType.StringType})
        ){
            backStackEntry ->
            DetailsScreans(navController = navController,backStackEntry.arguments?.getString("Movie"))
        }

    }
}