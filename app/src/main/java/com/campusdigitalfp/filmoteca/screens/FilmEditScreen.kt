package com.campusdigitalfp.filmoteca.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme



@Preview(showBackground = true)
@Composable
fun EditarPantalla()
{
    var titulo by remember { mutableStateOf("") }
    var director by remember {mutableStateOf("")}
    var estreno by remember { mutableIntStateOf(1990) }
    var url by remember {mutableStateOf("")}
    var imagen by remember {mutableIntStateOf(0)}
    var comentarios by remember {mutableStateOf("")}
    var genero by remember{mutableStateOf(false)}


    Column(
        modifier=Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Row ()
        {
            Image( painter = painterResource(R.drawable.palomitas)
                , contentDescription = null,
                Modifier.size(100.dp)
                    .weight(1f)
            )
            Button(onClick ={},
                modifier=Modifier.weight(1f)
                    .padding(top=16.dp),
            )
            {
                Text(text = "Capturar fotografía")
            }
            Spacer(modifier=Modifier
                .padding(4.dp))
            Button(onClick = {},
                modifier=Modifier.weight(1f)
                    .padding(top=16.dp)
                    .padding(end=4.dp))
            {
                Text(text="Seleccionar imagen")
            }
        }
        TextField(
            value=titulo,
            onValueChange = {newText ->titulo=newText},
            label={Text("Titulo")},
            placeholder = {Text("Titulo")},
            modifier=Modifier.fillMaxWidth(),
            singleLine=true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
    }

}



//@Composable
//fun FilmEditScreen (navController: NavHostController)
//{
//    Scaffold(topBar = { BarraSuperiorComun(navController, true, c_edit = true)}, content = { padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        )
//        {
//            Text(
//                text = "Editando película"
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Button(onClick = {
//                navController.previousBackStackEntry?.savedStateHandle?.set(
//                    "key_result",
//                    "RESULT_OK"
//                )
//                navController.popBackStack()
//            })
//            {
//                Text(text = stringResource(R.string.guardar))
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//            Button(onClick = {
//                navController.previousBackStackEntry?.savedStateHandle?.set(
//                    "key_result",
//                    "RESULT_CANCELED"
//                )
//                navController.popBackStack()
//            })
//            {
//                Text(text = stringResource(R.string.cancelar))
//            }
//        }
//    }
//    )
//
//}
