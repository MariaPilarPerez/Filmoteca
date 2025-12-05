package com.campusdigitalfp.filmoteca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

//una columna con texto y dos botones

@Composable
fun FilmEditScreen (navController: NavHostController)
{
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Text(
            text="Editando película")
        Spacer(modifier=Modifier.height(8.dp))
        Button(onClick = {navController.popBackStack()})
        {
            Text(text= stringResource(R.string.guardar))
        }
        Spacer(modifier=Modifier.height(8.dp))
        Button(onClick = {navController.navigate("lista")})
        {
            Text(text= stringResource(R.string.cancelar))
        }
    }

}
//@Preview (showBackground = true)
//@Composable
//fun VistaDatosFilm()
//{
//    FilmotecaTheme {
//        FilmEditScreen()
//    }
//}