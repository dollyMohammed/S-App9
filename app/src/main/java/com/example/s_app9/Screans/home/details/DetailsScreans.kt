package com.example.s_app9.Screans.home.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.s_app9.Movie
import com.example.s_app9.getMovies
import com.example.s_app9.widgets.MovieRow
import java.nio.file.WatchEvent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreans(navController: NavController, movieId: String?){
    val newmovieList= getMovies().filter { Movie ->
        Movie.id==movieId

    }
    
    Scaffold(topBar = {
        TopAppBar(title = { })
        Row (horizontalArrangement = Arrangement.Start){
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="" ,
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "Movie")
        }
    }) {
         Surface (modifier = Modifier
             .fillMaxWidth()
             .fillMaxHeight()){
             Column(verticalArrangement = Arrangement.Top,
                 horizontalAlignment = Alignment.CenterHorizontally,
                 modifier = Modifier.padding(top = 55.dp)) {
                 MovieRow(movie = newmovieList.first())
                 Spacer(modifier = Modifier.height(8.dp))
                 Text(text = "Movie Row")
                 HorizantalScrollableImageView(newmovieList)

             }
         }

    }
}

@Composable
private fun HorizantalScrollableImageView(newmovieList: List<Movie>) {
    LazyRow {
        items(newmovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(240.dp)
            ) {
                Image(painter = rememberImagePainter(data = image), contentDescription = "Movie Images")

            }

        }
    }
}