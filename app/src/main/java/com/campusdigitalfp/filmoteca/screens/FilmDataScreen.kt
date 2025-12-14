package com.campusdigitalfp.filmoteca.screens

import android.content.Context
import android.content.Intent
import android.content.LocusId
import android.media.Image
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.savedstate.serialization.saved
import com.campusdigitalfp.filmoteca.Datos.FilmDataSource
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import kotlin.text.toIntOrNull


@Composable
fun FilmDataScreen(navController: NavHostController, film: Film )

{
    val context=LocalContext.current

    Scaffold(topBar = {BarraSuperiorComun(navController,true)}, content = { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 100.dp),
            verticalArrangement = Arrangement.Top,
            //horizontalAlignment = Alignment.CenterHorizontally
            // porque si no, no puedo alinear a la izquierda el texto del comentario.
        )
        {
            Row {
                Spacer(modifier = Modifier.height(16.dp))
                film.imageResId.let{
                Image( painter=painterResource(it),
                    contentDescription = null,
                    Modifier.size(200.dp)
                )}
                Column() {
                    film.title?.let {
                        Text(
                            text = it,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    }
                    Text(
                        text = stringResource(R.string.director),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    film.director?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = stringResource(R.string.a_o_de_estreno),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = film.year.toString(),
                        fontSize = 16.sp
                    )
                    val generoList = context.resources.getStringArray(R.array.genero_list)
                    Text(
                        text = generoList[film.genre],
                        fontSize = 16.sp
                    )
                    val formatoList = context.resources.getStringArray(R.array.formato_list)
                    Text(
                        text = formatoList[film.format],
                        fontSize = 16.sp
                    )
                }
            }
            Row {
                Button(onClick = {
                    film.imdbUrl?.let {
                         VerEnIMDB(film.imdbUrl!!, context)}},
                    Modifier
                        .weight(1f)
                        .padding(8.dp))
                    {
                        Text(
                            text = stringResource(R.string.ver_en_imdb)
                        )

                }
            }
            Row(modifier=Modifier
                .padding(start = 16.dp)
                .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start
            )
            {

                film.comments?.let {
                    Text(it,
                        modifier=Modifier,
                       // textAlign = TextAlign.Start

                    )
                }
            }
            Row {
                Button(onClick = {navController.popBackStack()},
                    Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .padding(end = 4.dp))
                { Text(text = stringResource(R.string.volver)) }
                Button(onClick = {navController.navigate("editar/${film.id}")}, Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
                    .padding(end = 8.dp))
                { Text(text = stringResource(R.string.editar_pelicula)) }
            }
        }
    }
    )

}

fun VerEnIMDB(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }
    context.startActivity(intent)
}


