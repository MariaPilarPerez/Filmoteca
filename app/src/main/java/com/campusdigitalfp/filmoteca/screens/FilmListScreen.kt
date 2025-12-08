package com.campusdigitalfp.filmoteca.screens

import android.provider.Settings.Global.getString
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.showToast
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

// una columna con tres botones


@Composable
fun FilmListScreen(navController: NavHostController)
{
    Column(
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {navController.navigate("datosfilm/Pelicula A")})
        {
            Text(text = stringResource(R.string.ver_pelicula_A))
        }
        Button(onClick = {navController.navigate("datosfilm/Pelicula B")})
        {
            Text(text = stringResource(R.string.ver_pelicula_B))
        }
        Button(onClick = {navController.navigate("about") })
        {
            Text(text = stringResource(R.string.acerca_De))


        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun Verlistafilms()
//{
//    FilmotecaTheme {
//        FilmListScreen()
//    }
//}

