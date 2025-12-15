package com.campusdigitalfp.filmoteca

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.campusdigitalfp.filmoteca.Datos.FilmDataSource
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.navigation.Navigation
import com.campusdigitalfp.filmoteca.screens.FilmDataScreen
import com.campusdigitalfp.filmoteca.screens.FilmListScreen
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FilmDataSource.loadData(this)
        enableEdgeToEdge()
        setContent {
            FilmotecaTheme {
                Navigation()
                }
            }
        }
    }




@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold(topBar = { BarraSuperiorComun(navController,true)}, content = { padding ->
        //columna con elementos Creado por, seguido de imagen y seguido de row con dos botones
        // y otro elemento de la columna al final que es un boton
        val context = LocalContext.current

    Column(modifier= Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text= stringResource(R.string.creado_por_pilar),
                fontSize = 16.sp
            )
            Spacer(modifier=Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.perfilchica),
                contentDescription = "Foto de perfil"
            )
            Spacer(modifier=Modifier.height(8.dp))
            Row(
                modifier=Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.Absolute.Center
            )
            {
                Button(
                    onClick = {
                        abrirPaginaWeb(
                            "https://www.filmaffinity.com/es/main.html",
                            context
                        )
                        //showToast( context,
                        //context.getString(R.string.funcionalidad_sin_implementar))
                    },
                    modifier= Modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.ir_al_sitio_web))
                }
                Spacer(modifier=Modifier.width(8.dp))
                Button(
                    onClick = {
                        mandarEmail(
                            context, "mdpperezgy@fpvirtualaragon.es",
                            context.getString(R.string.incidencia_con_filmoteca)
                        )
                    },
                    modifier=Modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.obtener_soporte))
                }
            }
            //Spacer(modifier=Modifier.height(4.dp))
            Button(onClick = {
                navController.navigate("lista")})
            {
                Text(text = stringResource(R.string.volver))
            }
        }
    }
    )
}

    //Aqui no se pone composable.
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun abrirPaginaWeb(url: String, context: Context) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        context.startActivity(intent)
    }

    fun mandarEmail(context: Context, email: String, asunto: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto: $email")
            putExtra(Intent.EXTRA_SUBJECT, asunto)
        }
        context.startActivity(intent)
    }

