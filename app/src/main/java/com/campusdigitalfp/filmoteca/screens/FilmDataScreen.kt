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
import androidx.compose.ui.unit.dp
import com.campusdigitalfp.filmoteca.R

//mostrar los datos de una pelicula
// una columna con un texto y tres botones

@Composable
fun FilmDataScreen(modifier: Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
    Text(text="Datos de la Pelicula",
        modifier.padding(8.dp))
    Spacer(modifier.height(4.dp))
    Button(onClick = {/*implementar */})
    {
        Text(text = stringResource(R.string.ver_pelicula_relacionada))
    }
        Button(onClick = {/*implementar */})
        {
            Text(text = stringResource(R.string.editar_pelicula))
        }
        Button(onClick = {/*implementar */})
        {
            Text(text = stringResource(R.string.volver_a_la_principal))
        }
    }
}
