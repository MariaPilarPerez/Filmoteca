package com.campusdigitalfp.filmoteca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

//mostrar los datos de una pelicula
// una columna con un texto y tres botones


@Composable
fun FilmDataScreen(navController: NavHostController, titulo: String) {
    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
    val context = LocalContext.current
    val result: String? = savedStateHandle?.get("key_result")

    Scaffold(topBar = { BarraSuperiorComun(navController, true)}, content = { padding ->


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )


        {
            Text(
                text = titulo,
                color = Color.Blue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold

            )
            Text(
                text = stringResource(R.string.datos_de_la_pelicula),
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Button(onClick = { navController.navigate("datosfilm/$titulo") })
            {
                Text(text = stringResource(R.string.ver_pelicula_relacionada))
            }
            Button(onClick = { navController.navigate("editar") })
            {
                Text(text = stringResource(R.string.editar_pelicula))

            }
            Button(onClick = {
                navController.navigate("lista")
                {
                    popUpTo("lista")
                    { inclusive = true }
                }
            })
            {
                Text(text = stringResource(R.string.volver_a_la_principal))
            }
            if (!result.equals(null)) {
                Text(modifier=Modifier.padding(top=16.dp),
                    text = if (result.equals("RESULT_OK")) "Edición guardada"
                    else "Edición Cancelada" //al haber solo dos resultados, me sirve la sentencia if
                )
            }
        }
    }
    )
}


// en el enunciado del ejercicio 10: dice que deberemos navegar a otra pantalla pasando un argumento
// con el nombre de la pelicula, pero creo que es lo que he puesto en la linea 51,
//Button(onClick = {navController.navigate("datosfilm/$titulo")})
//{
//    Text(text = stringResource(R.string.ver_pelicula_relacionada))
// que es volveer a mostrar la misma pantalla, ya que si no, termina la aplicación
