package com.campusdigitalfp.filmoteca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

//mostrar los datos de una pelicula
// una columna con un texto y tres botones

@Composable
fun FilmDataScreen()
{
    Column(
        modifier = Modifier
           .fillMaxHeight()
           .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = stringResource(R.string.datos_de_la_pelicula),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = {})
        {
            Text(text = stringResource(R.string.ver_pelicula_relacionada))
        }
        Button(onClick = {/*implementar */ })
        {
            Text(text = stringResource(R.string.editar_pelicula))
        }
        Button(onClick = {/*implementar */ })
        {
            Text(text = stringResource(R.string.volver_a_la_principal))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaDatoFilm()
{
    FilmotecaTheme {
        FilmDataScreen()
    }
}