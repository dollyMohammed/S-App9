package com.example.s_app9.navigation

import androidx.compose.ui.text.substring
import kotlin.jvm.Throws

enum class MovieScreans {
    HomeScrean,
    DetailsScrean;
    companion object{
        fun fromRoute(route:String?):MovieScreans
        =when(route?.substringBefore("/")){
            HomeScrean.name -> HomeScrean
            DetailsScrean.name -> DetailsScrean
            null -> HomeScrean
            else -> throw IllegalAccessException("Route $route is not recognize")
        }

    }

}
