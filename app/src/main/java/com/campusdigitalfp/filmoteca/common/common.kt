package com.campusdigitalfp.filmoteca.common


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu

import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.screens.Film
import com.campusdigitalfp.filmoteca.screens.NuevoFilm


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperiorComun(
         navController: NavHostController,
         atras: Boolean = true,
         c_edit: Boolean = false, //cancelación de la edición
        // isActionMode: MutableState<Boolean> = remember{mutableStateOf(false)},
        // selectedFilm: MutableList<Film> = remember {mutableStateListOf<Film>()}
)
{

    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary),
            title = {
                  Text(text = stringResource(R.string.filmoteca))
                    },
            navigationIcon = {
                if (atras) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                navController.navigate("lista") {
                                    popUpTo("lista de films") { inclusive = true }
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Ir a inicio"
                        )

                    }

//                    IconButton(onClick = {
//                        if (c_edit) {
//                            navController.previousBackStackEntry?.savedStateHandle?.set(
//                                "key_result",
//                                "RESULT_CANCELED"
//                            )
//                        }
//
//                        navController.popBackStack()
//                    })
//                    {
//
//                        Icon(
//                            imageVector = Icons.Default.Home,
//                            //imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = stringResource(R.string.volver)
//                        )
//                    }
                }
            },
        actions = {
            if (!atras)
                {
                IconButton(
                            onClick = { expanded = true }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(R.string.menu_de_opciones)
                            )

                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                onClick = {
                                    NuevoFilm()
                                    // val context = null
                                    //Toast.makeText(context,"Pelicula añadida",Toast.LENGTH_SHORT)
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = stringResource(R.string.nuevo),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                },
                                text = { Text(stringResource(R.string.nuevo)) }

                            )
                            DropdownMenuItem(
                                onClick = { navController.navigate("about") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Filled.Info,
                                        contentDescription = stringResource(R.string.acerca_De),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                },
                                text = { Text(stringResource(R.string.acerca_De)) }

                            )

                        }
                    }

            }
            )
}

