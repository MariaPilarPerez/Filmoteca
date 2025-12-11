package com.campusdigitalfp.filmoteca.screens

import android.R.attr.content
import android.media.Image
import android.provider.Settings.Global.getString
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.Datos.FilmDataSource
import com.campusdigitalfp.filmoteca.Datos.FilmDataSource.films
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.showToast
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

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
fun FilmListScreen(navController: NavHostController)
{
     Scaffold(topBar = { BarraSuperiorComun(navController, false)}, content = { padding ->


         Column(
             modifier = Modifier
                 .fillMaxHeight()
                 .fillMaxWidth(),
             //verticalArrangement = Arrangement.Center,
             //horizontalAlignment = Alignment.CenterHorizontally
         ) {
            LazyColumn(modifier = Modifier
                .weight(1f)
                .padding(top=100.dp)
                .padding(start=16.dp))
                {
                  items(films)
                  {
                      film->VistaFilm(film)
                  }
         }
//             Button(onClick = { navController.navigate("datosfilm/Pelicula A") })
//             {
//                 Text(text = stringResource(R.string.ver_pelicula_A))
//             }
//             Button(onClick = { navController.navigate("datosfilm/Pelicula B") })
//             {
//                 Text(text = stringResource(R.string.ver_pelicula_B))
//             }
//             Button(onClick = { navController.navigate("about") })
//             {
//                 Text(text = stringResource(R.string.acerca_De))
//
//
//             }
         }
     }
     )
}

@Composable
fun VistaFilm(film: Film)
{
    Row(modifier=Modifier.padding(8.dp))
    {
        film.title?.let { Text(text= it) }
    }
}

