package com.campusdigitalfp.filmoteca.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.Datos.FilmDataSource.films
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun

// una columna con tres botones

data class Film(
    var id: Int = 0,
    var imageResId: Int = 0, // Propiedades de la clase
    var title: String? = null,
    var director: String? = null,
    var year: Int = 0,
    var genre: Int = 0,
    var format: Int = 0,
    var imdbUrl: String? = null,
    var comments: String? = null
) {

    override fun toString(): String {
        // Al convertir a cadena mostramos su título
        return title ?: "<Sin título>"
    }

    companion object {
        const val FORMAT_DVD = 0 // Formatos
        const val FORMAT_BLURAY = 1
        const val FORMAT_DIGITAL = 2
        const val GENRE_ACTION = 0 // Géneros
        const val GENRE_COMEDY = 1
        const val GENRE_DRAMA = 2
        const val GENRE_SCIFI = 3
        const val GENRE_HORROR = 4
    }
}
@Composable
fun FilmListScreen(
    navController: NavHostController,

) {
    Scaffold(topBar = { BarraSuperiorComun(navController, false) }, content = { padding ->


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            //verticalArrangement = Arrangement.Center,
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 100.dp)
                    .padding(start = 16.dp)
            )
            {
                items(films)
                { film ->
                    VistaFilm(film, onClick = {
                        navController.navigate("datosfilm/${film.id}")
                    }, isSelected = true, onLongClick = {})


                }


            }
        }
    }
    )
}







@Composable
fun VistaFilm(film: Film, onClick:() -> Unit, onLongClick: () -> Unit, isSelected: Boolean )
{
    Row(modifier=Modifier.padding(8.dp)
        .combinedClickable(onClick=onClick, onLongClick = onLongClick)
        )
    {
        film.imageResId?.let {
            Image( painter=painterResource(it), contentDescription = null,
                modifier=Modifier.size(100.dp))
        }
        Spacer(modifier=Modifier.padding(4.dp))
        Column(modifier=Modifier.weight(1f))
        {
            film.title?.let { Text(text = it, fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            film.director?.let {Text(text= it, fontSize = 12.sp)}
        }


    }


}

