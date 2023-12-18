package com.example.s_app9.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.s_app9.Movie
import com.example.s_app9.getMovies
@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0], onClickItem:(String) -> Unit ={}){
    var expended by remember {
        mutableStateOf(false)
    }
    Card (modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onClickItem(movie.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface (modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape
            ){
                Image(painter = rememberImagePainter(data =  movie.images[0]), contentDescription ="Movie poster" )
               // Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Image")
            }
            Column (modifier = Modifier.padding(4.dp)){
                Text(text = movie.title,style= MaterialTheme.typography.titleLarge )
                Text(text = " Dirctor=${movie.title}",style= MaterialTheme.typography.titleLarge )
                Text(text ="Relesed ${movie.year}",style= MaterialTheme.typography.titleLarge )
                AnimatedVisibility(visible = expended) {
                    Column {
Text(text = buildAnnotatedString {
    withStyle(style = SpanStyle(color= Color.LightGray, fontSize = 13.sp)){
        append("plote:")

    }
    withStyle(style = SpanStyle(color= Color.LightGray, fontSize = 13.sp,
        fontWeight = FontWeight.Bold
    )){
        append(movie.plot)

    }


},
    modifier = Modifier.padding(3.dp)


)
                        Divider(modifier = Modifier.padding(6.dp))
                        Text(text = "Director=${movie.director}", style = MaterialTheme.typography.displayLarge)
                        Text(text = "Actors=${movie.actors}", style = MaterialTheme.typography.displayLarge)
                        Text(text = "Rating=${movie.rating}", style = MaterialTheme.typography.displayLarge)

                    }

                }
                Icon(imageVector = if (expended) Icons.Filled.KeyboardArrowDown
                    else
                        Icons.Filled.KeyboardArrowUp
                    , contentDescription = "Arrow down",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expended = !expended

                        })

            }

        }

    }
}
