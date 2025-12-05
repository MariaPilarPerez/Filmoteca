package com.campusdigitalfp.filmoteca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//una columna con texto y dos botones

@Composable
fun FilmEditScreen (modifier: Modifier)
{
    Column(modifier.fillMaxWidth()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Text(
            text="Editando película")
        Spacer(modifier.height(8.dp))
        Button(onClick = {})
        {Text(text="Guardar")}
        Spacer(modifier.height(8.dp))
        Button(onClick = {}){Text(text="Cancelar")}
    }

}