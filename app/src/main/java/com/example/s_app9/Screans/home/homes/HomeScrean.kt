package com.example.s_app9.Screans.home.homes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.s_app9.Movie
import com.example.s_app9.getMovies
import com.example.s_app9.navigation.MovieScreans
import com.example.s_app9.widgets.MovieRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScrean(navController: NavController){
    Scaffold (
        topBar = {

            Text(text = "Movie")
        }){
        MainContent(navController=navController)
    }

}
@Composable
fun MainContent(navController: NavController,
    movieList:List<Movie> = getMovies() ){
    Column(modifier = Modifier.padding(top=40.dp, start = 12.dp)) {
        LazyColumn{
            items(items=movieList){
                MovieRow(movie = it){ Movie ->

                    navController.navigate(route = MovieScreans.DetailsScrean.name+"/$Movie")
                    //Log.d("TAG", "MainContent: $movie")

                }
            }
        }

    }


}
