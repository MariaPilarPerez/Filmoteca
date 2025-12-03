package com.campusdigitalfp.filmoteca

import android.content.Context
import android.os.Bundle
import android.view.textclassifier.ConversationActions
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilmotecaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AboutScreen()
                }
            }
        }
    }
}
@Composable
fun AboutScreen(modifier: Modifier=Modifier){
    //columna con elementos Creado por, seguido de imagen y seguido de row con dos botones
// y otro elemento de la columna al final que es un boton
    val context = LocalContext.current
    Column(modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
       {
        Text(text= stringResource(R.string.creado_por_pilar),
            fontSize = 16.sp
            )
        Spacer(modifier.height(16.dp))
        Image( painter = painterResource(R.drawable.perfil), contentDescription = "Foto de perfil")
        Spacer(modifier.height(8.dp))
        Row(
            modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Absolute.Center
           )
           {
            Button(onClick = { showToast( context,
                context.getString(R.string.funcionalidad_sin_implementar))
                },
                modifier.weight(1f))  {
                Text(text= stringResource(R.string.ir_al_sitio_web))}
               Spacer(modifier.width(8.dp))
               Button(onClick = {showToast( context,
                   context.getString(R.string.funcionalidad_sin_implementar))
                },
                modifier.weight(1f)) {
                Text(text= stringResource(R.string.obtener_soporte))
            }
        }
           Spacer(modifier.height(8.dp))
        Button(onClick={showToast( context,
            context.getString(R.string.funcionalidad_sin_implementar))})
        {
            Text(text= stringResource(R.string.volver))
        }
        }
    }

//Aqui no se pone composable.
fun showToast(context: Context, message: String){
     Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}



@Preview(showBackground = true)
@Composable
fun AboutSreenPreview() {
    FilmotecaTheme {
       AboutScreen()
    }
}