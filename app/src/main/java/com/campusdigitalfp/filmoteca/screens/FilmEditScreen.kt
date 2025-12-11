package com.campusdigitalfp.filmoteca.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme




@Composable
fun FilmEditScreen(navController: NavHostController, titulo: String)
{
    var titulo by remember { mutableStateOf("") }
    var director by remember {mutableStateOf("")}
    var estreno by remember { mutableIntStateOf(1990) }
    var url by remember {mutableStateOf("")}
    var imagen by remember {mutableIntStateOf(0)}
    var comentarios by remember {mutableStateOf("")}
    var expandedgenero by remember{mutableStateOf(false)}
    var expandedformato by remember { mutableStateOf(false) }
    val context=LocalContext.current
    val generoList=context.resources.getStringArray(R.array.genero_list).toList()
    val formatoList=context.resources.getStringArray(R.array.formato_list).toList()
    var genero by remember {mutableIntStateOf(0)}
    var formato by remember {mutableIntStateOf(1)}
    var selectedGenero = generoList[genero]
    var selectedFormato = formatoList[formato]

    Scaffold(topBar = { BarraSuperiorComun(navController, true, c_edit = true)},
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(top = 100.dp),

                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                Row()
                {
                    Image(
                        painter = painterResource(R.drawable.palomitas), contentDescription = null,
                        Modifier.size(100.dp)
                            .weight(1f)
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier.weight(1f)
                            .padding(top = 16.dp),
                    )
                    {
                        Text(text = "Capturar fotografía")
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier.weight(1f)
                            .padding(top = 16.dp)
                            .padding(end = 4.dp)
                    )
                    {
                        Text(text = "Seleccionar imagen")
                    }
                }
                TextField(
                    value = titulo,
                    onValueChange = { newText -> titulo = newText },
                    label = { Text("Titulo") },
                    placeholder = { Text("Escribe el título") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                TextField(
                    value = director,
                    onValueChange = { newText -> director = newText },
                    label = { Text("Director") },
                    placeholder = { Text("Escribe el Director") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                var anyo: String = estreno.toString()
                TextField(
                    value = anyo,
                    onValueChange = { newText -> anyo = newText },
                    label = { Text("Año de estreno") },
                    placeholder = { Text("Escribe el año de estreno") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                TextField(
                    value = url,
                    onValueChange = { newText -> url = newText },
                    label = { Text("Enlace a IMDB") },
                    placeholder = { Text("Escribe el enlace a IMDB") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                //Column {
                Text(
                    "Genero",
                    modifier = Modifier.padding(16.dp)
                        .clickable { expandedgenero = true },
                    //textAlign = TextAlign.Start,

                    )
                DropdownMenu(
                    expanded = expandedgenero,
                    onDismissRequest = { expandedgenero = false }
                )
                {
                    generoList.forEach { genero ->
                        DropdownMenuItem(
                            onClick = {
                                selectedGenero = genero
                                expandedgenero = false
                            },
                            text = { Text(genero) },
                        )

                    }
                }
                Text(
                    "Formato",
                    modifier = Modifier.padding(16.dp)
                        .clickable { expandedformato = true },
                    //textAlign = TextAlign.Start,

                    )
                DropdownMenu(
                    expanded = expandedformato,
                    onDismissRequest = { expandedformato = false }
                )
                {
                    formatoList.forEach { formato ->
                        DropdownMenuItem(
                            onClick = {
                                selectedFormato = formato
                                expandedformato = false
                            },
                            text = { Text(formato) },
                        )

                    }
                }
                TextField(
                    value = comentarios,
                    onValueChange = { newText -> comentarios = newText },
                    label = { Text("Comentarios") },
                    placeholder = { Text("Pon aqui tus Comentarios") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                Row (Modifier.padding(start = 8.dp).padding(end=8.dp)){
                    Button(onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "key_result",
                            "RESULT_OK"
                        )
                        navController.popBackStack()
                    }, Modifier.weight(1f))
                    {
                        Text(text = stringResource(R.string.guardar))
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Button(onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "key_result",
                            "RESULT_CANCELED"
                        )
                        navController.popBackStack()
                    }, Modifier.weight(1f))
                    {
                        Text(text = stringResource(R.string.cancelar))
                    }

                }
            }

        }
    )
}







@Composable
fun oldFilmEditScreen (navController: NavHostController)
{
    Scaffold(topBar = { BarraSuperiorComun(navController, true, c_edit = true)},
        content = { paddingValues: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Editando película"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                navController.previousBackStackEntry?.savedStateHandle?.set(
                    "key_result",
                    "RESULT_OK"
                )
                navController.popBackStack()
            })
            {
                Text(text = stringResource(R.string.guardar))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                navController.previousBackStackEntry?.savedStateHandle?.set(
                    "key_result",
                    "RESULT_CANCELED"
                )
                navController.popBackStack()
            })
            {
                Text(text = stringResource(R.string.cancelar))
            }
        }
    }
    )

}
