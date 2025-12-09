package com.campusdigitalfp.filmoteca.screens

import android.R.attr.content
import android.provider.Settings.Global.getString
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.showToast
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

// una columna con tres botones


@Composable
fun FilmListScreen(navController: NavHostController)
{
     Scaffold(topBar = { BarraSuperiorComun(navController, false)}, content = { padding ->
         Column(
             modifier = Modifier
                 .fillMaxHeight()
                 .fillMaxWidth(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             Button(onClick = { navController.navigate("datosfilm/Pelicula A") })
             {
                 Text(text = stringResource(R.string.ver_pelicula_A))
             }
             Button(onClick = { navController.navigate("datosfilm/Pelicula B") })
             {
                 Text(text = stringResource(R.string.ver_pelicula_B))
             }
             Button(onClick = { navController.navigate("about") })
             {
                 Text(text = stringResource(R.string.acerca_De))


             }
         }
     }
     )
}
